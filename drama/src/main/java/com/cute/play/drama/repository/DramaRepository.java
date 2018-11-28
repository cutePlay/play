package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.entity.DramaRole;
import com.cute.play.drama.entity.GameRoom;
import com.cute.play.drama.mapper.DramaMapper;
import com.cute.play.drama.mapper.DramaRoleMapper;
import com.cute.play.drama.mapper.GameRoomMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Repository
public class DramaRepository extends ServiceImpl<DramaMapper, Drama> {
    @Autowired
    private DramaRoleMapper dramaRoleMapper;
    @Autowired
    private GameRoomMapper gameRoomMapper;

    public IPage<DramaRole> getDramaRoleList(Long dramaId) {
        DramaRole entity = new DramaRole();
        entity.setDramaId(dramaId);
        List<DramaRole> list = dramaRoleMapper.selectList(new QueryWrapper<>(entity));
        long size = list.size();
        IPage<DramaRole> page = new Page<>(1L,size,size);
        page.setRecords(list);
        return page;
    }

    public Long createRoom(Long dramaId) {
        GameRoom entity = new GameRoom();
        entity.setDramaId(dramaId);
        gameRoomMapper.insert(entity);
        return entity.getId();
    }
}
