package com.cute.mahjong.bean;

import com.cute.mahjong.constant.DragonType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
@Data
@AllArgsConstructor
public class DragonTile implements Tile{
    private DragonType type;

    @Override
    public String display() {
        return type.getDisplay();
    }

    @Override
    public Tile next() {
        return new DragonTile(DragonType.values()[(type.ordinal()+1)%DragonType.values().length]);
    }
}
