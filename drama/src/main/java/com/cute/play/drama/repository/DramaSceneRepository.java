package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.DramaScene;
import com.cute.play.drama.mapper.DramaSceneMapper;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Component
public class DramaSceneRepository extends ServiceImpl<DramaSceneMapper,DramaScene> {
    public List<DramaScene> getDramaSceneList(Long dramaId){
        DramaScene dramaScene = new DramaScene();
        dramaScene.setDramaId(dramaId);
        Wrapper<DramaScene> query = new QueryWrapper<>(dramaScene);
        return this.list(query);
    }
}
