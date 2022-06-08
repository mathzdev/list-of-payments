package com.github.fenxlol.listofpayments.repository;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditRepository extends CrudRepository<Credit, Long> {

    Credit findFirstByPaymentsIn(List<Payment> payments);

}
