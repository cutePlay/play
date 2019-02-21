package com.cute.mahjong.constant;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public enum SuitType implements TileDisplay{
    /**
     * 筒
     */
    DOT("筒"),
    /**
     * 条
     */
    BAMBOO("条"),
    /**
     * 万
     */
    CHARACTER("万")
    ;
    String display;
    SuitType(String display){
        this.display = display;
    }

    @Override
    public String getDisplay() {
        return display;
    }
}
