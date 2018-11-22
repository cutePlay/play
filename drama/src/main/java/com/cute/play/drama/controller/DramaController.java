package com.cute.play.drama.controller;

import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.entity.DramaRole;
import com.cute.play.drama.repository.DramaRepository;
import com.cute.play.drama.repository.DramaRoleRepository;
import java.util.List;
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
public class DramaController {
    @Autowired
    private DramaRepository dramaRepository;
    @Autowired
    private DramaRoleRepository dramaRoleRepository;

    @GetMapping
    public List<Drama> list() {
        return dramaRepository.list(null);
    }

    @GetMapping("{id}")
    public Drama get(@PathVariable Long id) {
        return dramaRepository.getById(id);
    }

    @GetMapping("{id}/roles")
    public List<DramaRole> roles(@PathVariable Long id){
        return dramaRoleRepository.getDramaRoleList(id);
    }

    @GetMapping("{dramaId}/roles/{id}")
    public DramaRole role(@PathVariable Long dramaId, @PathVariable Long id){
        return dramaRoleRepository.getById(id);
    }
}
