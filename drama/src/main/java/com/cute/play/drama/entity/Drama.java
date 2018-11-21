package com.cute.play.drama.entity;

import com.cute.play.drama.entity.enums.DramaTypeEnum;
import lombok.Data;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Data
public class Drama extends BaseEntity {
    private String title;
    private String synopsis;
    private String truth;
    private DramaTypeEnum type;
}
