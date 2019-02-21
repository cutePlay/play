package com.cute.mahjong.constant;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
public enum RankType {
    /**
     * 1
     */
    ONE("一"),
    /**
     * 二
     */
    TWO("二"),
    /**
     * 三
     */
    THREE("三"),
    /**
     * 四
     */
    FOUT("四"),
    /**
     * 五
     */
    FIVE("五"),
    /**
     * 六
     */
    SIX("六"),
    /**
     * 七
     */
    SEVEN("七"),
    /**
     * 八
     */
    EIGHT("八"),
    /**
     * 九
     */
    NINE("九");
    String display;
    RankType(String display){
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
