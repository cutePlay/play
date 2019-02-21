package com.cute.mahjong.bean;

import com.cute.mahjong.constant.WindType;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
@Data
public class Player {
    private WindType type;
    private List<Tile> tiles;
    private String name;
    public Player(String name, int ordinal){
        this.name = name;
        tiles = Lists.newArrayList();
        this.type = WindType.values()[ordinal];
    }

}
