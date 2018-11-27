package com.cute.play.drama.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.entity.DramaRole;
import com.cute.play.drama.repository.DramaRepository;
import com.cute.play.drama.repository.DramaRoleRepository;
import com.cute.play.drama.vo.PageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyuting
 * @since 2018/11/16
 */
@RestController
@RequestMapping("/api/dramas")
@Slf4j
public class DramaController {
    @Autowired
    private DramaRepository dramaRepository;
    @Autowired
    private DramaRoleRepository dramaRoleRepository;

    @GetMapping
    public IPage<Drama> list(PageRequest request) {
        Page<Drama> page = new Page<>(request.getCurrent(),request.getSize());
        return dramaRepository.page(page,null);
    }

    @GetMapping("{id}")
    public Drama get(@PathVariable Long id) {
        return dramaRepository.getById(id);
    }

    @GetMapping("{id}/roles")
    public IPage<DramaRole> roles(@PathVariable Long id){
        return dramaRoleRepository.getDramaRoleList(id);
    }

    @GetMapping("{id}/roles/{roleId}")
    public DramaRole role(@PathVariable Long id, @PathVariable Long roleId){
        return dramaRoleRepository.getById(roleId);
    }
}
