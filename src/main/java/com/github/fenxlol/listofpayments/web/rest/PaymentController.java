package com.github.fenxlol.listofpayments.web.rest;

import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public List<Payment> listOfPayments() {
        return paymentService.listOfPayments();
    }

}
