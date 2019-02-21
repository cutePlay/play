package com.cute.mahjong.bean;

import com.cute.mahjong.constant.RankType;
import com.cute.mahjong.constant.SuitType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
@Data
@AllArgsConstructor
public class SuitTile implements Tile{
    private RankType rank;
    private SuitType type;

    @Override
    public String display() {
        return rank.getDisplay()+type.getDisplay();
    }

    @Override
    public Tile next() {
        RankType[] ranks = RankType.values();
        return new SuitTile(ranks[(rank.ordinal()+1)%ranks.length],type);
    }
}
