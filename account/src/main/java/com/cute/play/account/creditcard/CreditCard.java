package com.cute.play.account.creditcard;

import com.cute.play.account.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private CreditCardType type;

    public CreditCard(String number, CreditCardType type){
        this.number = number;
        this.type = type;
    }
}
