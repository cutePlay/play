package com.cute.mahjong.bean;

import com.cute.mahjong.factory.MahjongFactory;
import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public class Game {

    /**
     * 筛子
     */
    private List<Dice> dices;
    /**
     * 麻将牌
     */
    private List<Tile> tiles;

    public Game(MahjongFactory mahjong, int diceNum){
        tiles = mahjong.create();
        dices = Lists.newArrayListWithExpectedSize(diceNum);
        for(int i = 0;i<diceNum;i++) {
            dices.add(new Dice());
        }
    }

}
