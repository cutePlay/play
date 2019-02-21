package com.cute.play.account.customer;

import com.cute.play.account.BaseEntity;
import com.cute.play.account.account.Account;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hanyuting
 * @since 2019/1/31
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Customer(String firstName, String lastName, String email,
        Account account){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.account = account;
    }
}
