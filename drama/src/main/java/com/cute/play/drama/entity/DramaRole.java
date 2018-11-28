package com.cute.play.drama.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Getter
@Setter
public class DramaRole extends BaseEntity {
    private String name;
    private String portrait;
    private String synopsis;
    private Long dramaId;
}
