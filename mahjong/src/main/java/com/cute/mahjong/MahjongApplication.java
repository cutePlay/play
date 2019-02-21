package com.cute.mahjong;

import com.cute.mahjong.bean.Player;
import com.cute.mahjong.bean.Tile;
import com.cute.mahjong.constant.WindType;
import com.cute.mahjong.factory.CommonMahjong;
import com.cute.mahjong.factory.MahjongFactory;
import com.cute.mahjong.middleware.MahjongDice;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public class MahjongApplication {

    public static void main(String[] args) {
        List<Player> players = Lists.newArrayListWithExpectedSize(4);
        //玩家入席
        for(int i = 0;i < 4;i++){
            players.add(new Player("玩家"+i,i));
        }
        //掷骰子
        MahjongDice mahjongDice = new MahjongDice();
        int dir = mahjongDice.getMod();
        //决定东家
        Collections.rotate(players,-dir);
        players.forEach(player -> player.setType(WindType.values()[(4+player.getType().ordinal()-dir)%4]));
        players.stream().map(Player::toString).forEach(a->System.out.println(a));
        //起手牌
        mahjongDice.hurl();
        int startIndex = mahjongDice.startIndex();

        MahjongFactory mahjong = new CommonMahjong();

        List<Tile> tiles = mahjong.create();
        Collections.shuffle(tiles);
        System.out.println(tiles.get(startIndex));
        Collections.rotate(tiles,-startIndex);
        System.out.println(tiles.get(0));
//        Board shuffle = new Board(mahjong.create());
//        shuffle.print();
    }
}
