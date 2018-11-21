package com.cute.play.drama.controller;

import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.repository.DramaRepository;
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
@RequestMapping("drama")
public class DramaController {
    @Autowired
    private DramaRepository dramaRepository;

    @GetMapping("{id}/introduction")
    public String introduction(@PathVariable Integer id) {
        Drama drama = dramaRepository.getById(id);
        return drama.getSynopsis();
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("dramas", dramaRepository.list(null));
        return "list";
    }
}
