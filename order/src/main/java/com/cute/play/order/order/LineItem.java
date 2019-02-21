package com.cute.play.order.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItem {

    private String name, productId;

    private Integer quantity;

    private Double price, tax;
}
