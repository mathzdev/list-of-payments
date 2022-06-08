package com.github.fenxlol.listofpayments.service;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.repository.CreditRepository;
import com.github.fenxlol.listofpayments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CreditRepository creditRepository;

    public List<Payment> listOfPayments() {
        List<Payment> payments = new ArrayList();

        for (Payment payment : paymentRepository.findAll()) {
            List<Payment> paymentsToFind = new ArrayList();
            paymentsToFind.add(payment);

            Credit credit = creditRepository.findFirstByPaymentsIn(paymentsToFind);
            credit.setPayments(null);

            payment.setCredit(credit);
            payments.add(payment);
        }

        return payments;
    }

}
