package com.github.fenxlol.listofpayments.web.rest;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    CreditService creditService;

    @GetMapping
    public List<Credit> listOfCredits() {
        return creditService.listOfCredits();
    }

    @PostMapping
    public Credit createCreditAndPayments(@RequestBody Credit credit) throws Exception {
        return creditService.createCreditAndPayments(credit);
    }

}
