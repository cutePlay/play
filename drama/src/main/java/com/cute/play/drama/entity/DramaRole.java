package com.cute.play.drama.entity;

import lombok.Data;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Data
public class DramaRole extends BaseEntity {
    private String name;
    private String portrait;
    private String book;
    private Long dramaId;
}
