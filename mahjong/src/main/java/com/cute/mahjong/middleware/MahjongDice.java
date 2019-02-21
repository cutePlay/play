package com.cute.mahjong.middleware;

import com.cute.mahjong.bean.Dice;
import lombok.Getter;

/**
 * @author hanyuting
 * @since 2019/2/21
 */
public class MahjongDice {
    private static final int BASE = 4;
    private static final int[] START = {14,115,81,47};
    private Dice dice1;
    private Dice dice2;
    @Getter
    private int mod;
    public MahjongDice(){
        dice1 = new Dice();
        dice2 = new Dice();
        mod = ((dice1.getNum()+dice2.getNum())%BASE-1+BASE)%BASE;
    }

    public void hurl(){
        dice1.hurl();
        dice2.hurl();
        mod = ((dice1.getNum()+dice2.getNum())%BASE-1+BASE)%BASE;
        System.out.println(toString());
    }


    public int startIndex(){
        return START[mod];
    }
    @Override
    public String toString(){
        return dice1.getNum()+" "+dice2.getNum();
    }
}
