package com.github.fenxlol.listofpayments.repository;

import com.github.fenxlol.listofpayments.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    
}
