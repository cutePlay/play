package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cute.play.drama.entity.DramaRole;
import com.cute.play.drama.mapper.DramaRoleMapper;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Component
public class DramaRoleRepository extends ServiceImpl<DramaRoleMapper,DramaRole> {
    public List<DramaRole> getDramaRoleList(Long dramaId){
        DramaRole dramaRole = new DramaRole();
        dramaRole.setDramaId(dramaId);
        return list(new QueryWrapper<>(dramaRole));
    }
}
