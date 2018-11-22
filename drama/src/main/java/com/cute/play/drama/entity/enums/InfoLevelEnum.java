package com.cute.play.drama.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author hanyuting
 * @since 2018/11/22
 */
public enum InfoLevelEnum implements IEnum<String> {
    /**
     * 人物私有
     */
    PRIVATE,
    /**
     * 特殊条件
     */
    SPECIAL,
    /**
     * 排除某人
     */
    FILTER,
    /**
     * 随机抽取
     */
    RANDOM,
    /**
     * 直接公开
     */
    PUBLIC;

    @Override
    public String getValue() {
        return this.name();
    }
}
