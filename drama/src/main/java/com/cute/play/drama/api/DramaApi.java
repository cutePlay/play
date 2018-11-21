package com.cute.play.drama.api;

import com.cute.play.drama.repository.DramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@RestController
@RequestMapping("/api/drama")
public class DramaApi {

    @Autowired
    private DramaRepository dramaRepository;

    @GetMapping("{id}")
    public String get(@PathVariable Integer id) {
        return dramaRepository.getById(id).getSynopsis();
    }
}
