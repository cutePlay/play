package com.cute.play.account.customer;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author hanyuting
 * @since 2019/1/31
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Optional<Customer> findByEmailContaining(String email);
}
