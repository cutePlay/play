package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.DramaInfo;
import com.cute.play.drama.entity.DramaScene;
import com.cute.play.drama.entity.GameRoom;
import com.cute.play.drama.mapper.DramaInfoMapper;
import com.cute.play.drama.mapper.DramaSceneMapper;
import com.cute.play.drama.mapper.GameRoomMapper;
import com.cute.play.drama.vo.GameRoomInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Repository
public class GameRoomRepository extends ServiceImpl<GameRoomMapper, GameRoom> {
    @Autowired
    private DramaSceneMapper dramaSceneMapper;
    @Autowired
    private DramaInfoMapper dramaInfoMapper;

    public GameRoomInfo gameRoomInfo(Long id){
        GameRoomInfo gameRoomInfo = new GameRoomInfo();
        GameRoom gameRoom = this.getById(id);
        if(gameRoom != null) {
            BeanUtils.copyProperties(gameRoom, gameRoomInfo);
            DramaScene scene = new DramaScene();
            scene.setDramaId(gameRoom.getDramaId());
            gameRoomInfo.setScenes(dramaSceneMapper.selectList(new QueryWrapper<>(scene)));
            DramaInfo info = new DramaInfo();
            info.setDramaId(gameRoomInfo.getDramaId());
            info.setSceneFlag(gameRoom.getSceneFlag());
            gameRoomInfo.setInfos(dramaInfoMapper.selectList(new QueryWrapper<>(info)));
        }
        return gameRoomInfo;
    }
}
