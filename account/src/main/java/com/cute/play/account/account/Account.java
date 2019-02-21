package com.cute.play.account.account;

import com.cute.play.account.BaseEntity;
import com.cute.play.account.address.Address;
import com.cute.play.account.creditcard.CreditCard;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String accountNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CreditCard> creditCards = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    public Account(String accountNumber, Set<Address> addresses){
        this.accountNumber = accountNumber;
        this.addresses.addAll(addresses);
    }
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
    }
}
