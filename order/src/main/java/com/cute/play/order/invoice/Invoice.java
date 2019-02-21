package com.cute.play.order.invoice;

import com.cute.play.account.address.Address;
import com.cute.play.account.address.AddressType;
import com.cute.play.order.BaseEntity;
import com.cute.play.order.order.Order;
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
public class Invoice extends BaseEntity {
    @Id
    private String invoiceId;

    private String customerId;

    private List<Order> orders = new ArrayList<>();

    private Address billingAddress;

    private InvoiceStatus invoiceStatus;

    public Invoice(String customerId, Address billingAddress){
        this.customerId = customerId;
        this.billingAddress = billingAddress;
        this.billingAddress.setAddressType(AddressType.BILLING);
        this.invoiceStatus = InvoiceStatus.CREATED;
    }

    public void addOrder(Order order){
        order.setAccountNumber(this.customerId);
        orders.add(order);
    }
}
