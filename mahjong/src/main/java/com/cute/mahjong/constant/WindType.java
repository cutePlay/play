package com.cute.mahjong.constant;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public enum WindType {
    /**
     * 东风
     */
    EAST("东"),
    /**
     * 南风
     */
    SOUTH("南"),
    /**
     * 西风
     */
    WEST("西"),
    /**
     * 北风
     */
    NORTH("北")
    ;
    String display;
    WindType(String display){
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

}
