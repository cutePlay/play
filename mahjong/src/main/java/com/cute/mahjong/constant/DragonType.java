package com.cute.mahjong.constant;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public enum DragonType implements TileDisplay{
    /**
     * 白板
     */
    WHITE("白板"),
    /**
     * 发财
     */
    GREEN("发财"),
    /**
     * 红中
     */
    RED("红中")
    ;
    String display;
    DragonType(String display){
        this.display = display;
    }

    @Override
    public String getDisplay() {
        return display;
    }
}
