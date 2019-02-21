package com.cute.play.order;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
@Data
public class BaseEntity {
    private DateTime lastModified, createdAt;
}
