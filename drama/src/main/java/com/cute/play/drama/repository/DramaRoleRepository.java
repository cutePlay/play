package com.cute.play.drama.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public IPage<DramaRole> getDramaRoleList(Long dramaId){
        DramaRole entity = new DramaRole();
        entity.setDramaId(dramaId);
        List<DramaRole> list = super.list(new QueryWrapper<>(entity));
        long size = list.size();
        IPage<DramaRole> page = new Page<>(1L,size,size);
        page.setRecords(list);
        return page;
    }
}
