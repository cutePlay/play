package com.cute.play.drama.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
public enum DramaTypeEnum implements IEnum<String> {
    /**
     * 封闭
     */
    CLOSE,
    /**
     * 开放
     */
    OPEN,
    /**
     * 半开放
     */
    SEMI_OPEN;

    @Override
    public String getValue() {
        return this.name();
    }
}
