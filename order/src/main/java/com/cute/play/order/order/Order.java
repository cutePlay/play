package com.cute.play.order.order;

import com.cute.play.account.address.Address;
import com.cute.play.account.address.AddressType;
import com.cute.play.order.BaseEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order extends BaseEntity {

    @Id
    private String orderId;

    private String accountNumber;

    private OrderStatus orderStatus;

    private List<LineItem> lineItems = new ArrayList<>();

    private Address shippingAddress;

    public Order(String accountNumber, Address shippingAddress){
        this.accountNumber = accountNumber;
        this.shippingAddress = shippingAddress;
        this.shippingAddress.setAddressType(AddressType.SHIPPING);
        this.orderStatus = OrderStatus.PENDING;
    }

    public void addLineItem(LineItem lineItem){
        lineItems.add(lineItem);
    }
}
