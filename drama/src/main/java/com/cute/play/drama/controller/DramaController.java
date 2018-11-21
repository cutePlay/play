package com.cute.play.drama.controller;

import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.entity.DramaRole;
import com.cute.play.drama.repository.DramaRepository;
import com.cute.play.drama.repository.DramaRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hanyuting
 * @since 2018/11/16
 */
@Controller
@RequestMapping("dramas")
public class DramaController {
    @Autowired
    private DramaRepository dramaRepository;
    @Autowired
    private DramaRoleRepository dramaRoleRepository;

    @GetMapping("{id}/introduction")
    public String introduction(@PathVariable Long id) {
        Drama drama = dramaRepository.getById(id);
        return drama.getSynopsis();
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("dramas", dramaRepository.list(null));
        return "list";
    }

    @GetMapping("{id}/truth")
    public String truth(@PathVariable Long id) {
        Drama drama = dramaRepository.getById(id);
        return drama.getTruth();
    }

    @GetMapping("{id}/roles")
    public String roles(@PathVariable Long id,Model model){
        List<DramaRole> dramaRoles = dramaRoleRepository.getDramaRoleList(id);
        model.addAttribute("roles",dramaRoles);
        return "roles";
    }

    @GetMapping("{dramaId}/roles/{id}")
    public String role(@PathVariable Long dramaId, @PathVariable Long id,Model model){
        DramaRole role = dramaRoleRepository.getById(id);
        model.addAttribute("role",role);
        return String.format("%s/roles/book", dramaId);
    }
}
