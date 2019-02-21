package com.cute.mahjong.bean;

import java.util.Random;
import lombok.Getter;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
public class Dice {
    private static final Random RAN= new Random();
    private static final int BASE = 1;
    private static final int MAX = 6;
    @Getter
    private int num;
    public Dice(){
        hurl();
    }
    public void hurl(){
        this.num = RAN.nextInt(MAX)+BASE;
    }
}
