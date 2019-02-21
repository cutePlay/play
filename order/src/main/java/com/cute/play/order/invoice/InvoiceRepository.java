package com.cute.play.order.invoice;

import com.cute.play.account.address.Address;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, String> {
    Invoice findByBillingAddress(Address address);
}
