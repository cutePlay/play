package com.cute.play.drama.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hanyuting
 * @since 2018/11/27
 */
@Getter
@Setter
@ToString
public class PageRequest {
    private Long current;
    private Long size;
    public PageRequest(){
        this.current = 1L;
        this.size = 10L;
    }
}
