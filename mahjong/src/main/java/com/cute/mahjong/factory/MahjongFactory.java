package com.cute.mahjong.factory;

import com.cute.mahjong.bean.Tile;
import java.util.List;

/**
 * @author hanyuting
 * @since 2019/2/20
 */
public interface MahjongFactory {

    /**
     * 创建一副牌
     * @return
     */
    List<Tile> create();
}
