package com.cute.play.drama.entity;

import com.cute.play.drama.entity.enums.InfoLevelEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyuting
 * @since 2018/11/22
 */
@Getter
@Setter
public class DramaInfo extends BaseEntity {
    private String name;
    private String source;
    private InfoLevelEnum level;
    private Long dramaId;
    private Long sceneId;
    private Long roleId;
}
