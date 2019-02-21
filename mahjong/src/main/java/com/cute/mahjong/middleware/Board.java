package com.cute.mahjong.middleware;

import com.cute.mahjong.bean.Tile;
import java.util.Collections;
import java.util.List;

/**
 * 牌桌
 * @author hanyuting
 * @since 2019/2/20
 */
public class Board {

    /**
     * 所有牌
     */
    private List<Tile> tiles;
    /**
     * 当前下标
     */
    private int index;

    /**
     * 牌河
     */
    private List<Tile> riverTiles;

    public Board(List<Tile> tiles){
        this.tiles = tiles;
    }

    public void shuffle(int startIndex){
        Collections.shuffle(tiles);
        Collections.rotate(tiles,-startIndex);
        this.index = 0;
    }

    public void print(){
        tiles.forEach(tile->System.out.println(tile.display()));
    }

}
