package com.cute.play.drama.controller;

import com.cute.play.drama.entity.Drama;
import com.cute.play.drama.mapper.DramaMapper;
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
@RequestMapping("test")
public class DramaController {
    @Autowired
    private DramaMapper dramaMapper;
    @GetMapping("{id}")
    public Drama get(@PathVariable Integer id){
        return dramaMapper.selectById(id);
    }
}
