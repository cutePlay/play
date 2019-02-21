package com.cute.mahjong.bean;

import com.cute.mahjong.constant.WindType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
@Data
@AllArgsConstructor
public class WindTile implements Tile{
    private WindType type;

    @Override
    public String display() {
        return type.getDisplay()+"风";
    }

    @Override
    public Tile next() {
        return new WindTile(WindType.values()[(type.ordinal()+1)%WindType.values().length]);
    }
}
