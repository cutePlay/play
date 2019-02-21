package com.cute.play.account;

import com.cute.play.account.account.Account;
import com.cute.play.account.address.Address;
import com.cute.play.account.address.AddressType;
import com.cute.play.account.creditcard.CreditCard;
import com.cute.play.account.creditcard.CreditCardType;
import com.cute.play.account.customer.Customer;
import com.cute.play.account.customer.CustomerRepository;
import com.mysql.cj.exceptions.AssertionFailedException;
import javax.persistence.EntityNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hanyuting
 * @since 2019/1/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
@ActiveProfiles(profiles = "test")
public class AccountApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void customerTest(){
        Account account = new Account("123456");
        Customer customer = new Customer("Jane","Han", "jane_hyt@163.com", account);
        CreditCard creditCard = new CreditCard("1234567890",CreditCardType.VISA);
        customer.getAccount().getCreditCards().add(creditCard);

        String street1 = "Ave NW";
        Address address = new Address(street1, null, "DC", "Washington", "United States", AddressType.SHIPPING, 20500);
        customer.getAccount().getAddresses().add(address);

        customer = customerRepository.save(customer);

        Customer persistedResult = customerRepository.findById(customer.getId())
            .orElseThrow(()->new AssertionFailedException(new EntityNotFoundException("customer not found")));
        Assert.assertNotNull(persistedResult.getAccount());
        Assert.assertNotNull(persistedResult.getCreatedAt());
        Assert.assertNotNull(persistedResult.getLastModified());

        Assert.assertTrue(persistedResult.getAccount().getAddresses().stream()
        .anyMatch(add-> add.getStreet1().equalsIgnoreCase(street1)));

        customerRepository.findByEmailContaining(customer.getEmail())
            .orElseThrow(()->new AssertionFailedException(new RuntimeException("there's supposed to be a matching record! ")));
    }
}