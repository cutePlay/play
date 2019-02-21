package com.cute.play.order;

import com.cute.play.account.address.Address;
import com.cute.play.account.address.AddressType;
import com.cute.play.order.invoice.Invoice;
import com.cute.play.order.invoice.InvoiceRepository;
import com.cute.play.order.order.LineItem;
import com.cute.play.order.order.Order;
import com.cute.play.order.order.OrderRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderApplicationTests {

    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;

    @Before
    @After
    public void reset(){
        orderRepository.deleteAll();
        invoiceRepository.deleteAll();
    }

    @Test
    public void orderTest(){
        Address shippingAddress = new Address("Ave NW", null, "DC",
            "Washington", "United States", AddressType.SHIPPING, 20500);
        Order order = new Order("12345", shippingAddress);
        order.addLineItem(new LineItem("Best. Cloud. Ever. (T-Shirt, Men's Large)",
            "SKU-24642", 1, 21.99, .06));
        order.addLineItem(new LineItem("Like a BOSH (T-Shirt, Women's Medium)",
            "SKU-34563", 3, 14.99, .06));
        order.addLineItem(new LineItem("We're gonna need a bigger VM (T-Shirt, Women's Small)",
            "SKU-12464", 4, 13.99, .06));
        order.addLineItem(new LineItem("cf push awesome (Hoodie, Men's Medium)",
            "SKU-64233", 2, 21.99, .06));
        order = orderRepository.save(order);

        Assert.assertNotNull(order.getOrderId());
        Assert.assertEquals(order.getLineItems().size(), 4);

        Assert.assertEquals(order.getLastModified(), order.getCreatedAt());
        order = orderRepository.save(order);
        Assert.assertNotEquals(order.getLastModified(), order.getCreatedAt());

        Address billingAddress = new Address("875 Howard St", null, "CA",
            "San Francisco", "United States", AddressType.BILLING, 94103);
        String accountNumber = "918273465";
        Invoice invoice = new Invoice(accountNumber, billingAddress);
        invoice.addOrder(order);
        invoice = invoiceRepository.save(invoice);
        Assert.assertEquals(invoice.getOrders().size(), 1);

        Assert.assertEquals(invoiceRepository.findByBillingAddress(billingAddress), invoice);
    }
}