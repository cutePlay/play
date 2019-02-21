package com.cute.mahjong.factory;

import com.cute.mahjong.bean.DragonTile;
import com.cute.mahjong.bean.SuitTile;
import com.cute.mahjong.bean.Tile;
import com.cute.mahjong.bean.WindTile;
import com.cute.mahjong.constant.DragonType;
import com.cute.mahjong.constant.RankType;
import com.cute.mahjong.constant.SuitType;
import com.cute.mahjong.constant.WindType;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public class CommonMahjong implements MahjongFactory {
    private static final int TILE_SIZE = 136;
    private static final int BASE = 4;
    @Override
    public List<Tile> create() {
        List<Tile> tiles = Lists.newArrayListWithExpectedSize(TILE_SIZE);
        Arrays.stream(SuitType.values()).forEach(suit->
            Arrays.stream(RankType.values()).forEach(rank->{
                for (int i = 0; i < BASE; i++) {
                    tiles.add(new SuitTile(rank, suit));
                }
            })
        );
        Arrays.stream(DragonType.values()).forEach(type->{
            for (int i = 0; i < BASE; i++) {
                tiles.add(new DragonTile(type));
            }
        });
        Arrays.stream(WindType.values()).forEach(type-> {
            for (int i = 0; i < BASE; i++) {
                tiles.add(new WindTile(type));
            }
        });
        return tiles;
    }
}
