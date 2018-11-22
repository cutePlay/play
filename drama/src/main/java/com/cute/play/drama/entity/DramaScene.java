package com.cute.play.drama.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyuting
 * @since 2018/11/22
 */
@Getter
@Setter
public class DramaScene extends BaseEntity {
    private String name;
    private Byte sort;
    private Long dramaId;
}
