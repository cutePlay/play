package com.cute.play.drama.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hanyuting
 * @since 2018/11/21
 */
@Getter
@Setter
class BaseEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String creator;
    private Date created;
    private String modifier;
    private Date modified;
    @TableLogic
    private Byte deleted;
}
