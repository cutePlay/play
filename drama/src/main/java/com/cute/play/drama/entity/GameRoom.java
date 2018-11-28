package com.cute.play.drama.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hanyuting
 * @since 2018/11/28
 */
@Getter
@Setter
@ToString
public class GameRoom extends BaseEntity {
    private Long dramaId;
    private Byte sceneFlag;
}
