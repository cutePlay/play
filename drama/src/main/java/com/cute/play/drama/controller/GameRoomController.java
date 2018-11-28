package com.cute.play.drama.controller;

import com.cute.play.drama.repository.GameRoomRepository;
import com.cute.play.drama.vo.GameRoomInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hanyuting
 * @since 2018/11/28
 */
@RestController
@RequestMapping("api/gameRooms")
public class GameRoomController {
    @Autowired
    private GameRoomRepository gameRoomRepository;

    @GetMapping("{id}")
    public GameRoomInfo get(@PathVariable Long id){
        return gameRoomRepository.gameRoomInfo(id);
    }
}
