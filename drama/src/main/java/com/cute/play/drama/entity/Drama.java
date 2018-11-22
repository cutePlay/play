package com.cute.play.drama.entity;

import com.cute.play.drama.entity.enums.DramaTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Getter
@Setter
public class Drama extends BaseEntity {
    private String title;
    private String cover;
    private String synopsis;
    private String truth;
    private DramaTypeEnum type;
}
