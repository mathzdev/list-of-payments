package com.github.fenxlol.listofpayments.service;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    CreditRepository creditRepository;

    public List<Credit> listOfCredits() {
        List<Credit> credits = new ArrayList();

        for (Credit credit : creditRepository.findAll()) {
            credits.add(credit);
        }

        return credits;
    }

    public Credit createCreditAndPayments(Credit credit) throws Exception {
        if (credit.getTerms() < 4 || credit.getTerms() > 52) {
            throw new Exception("Terms field need to be a number >= 4 or <= 52");
        }

        if (credit.getRate() < 2 || credit.getRate() > 99) {
            throw new Exception("Rate field need to be a number > 1 or < 100");
        }

        if (credit.getAmount() < 2 || credit.getAmount() > 999999) {
            throw new Exception("Amount field need to be a number > 1 or < 999999");
        }

        credit = creditRepository.save(createPayments(credit));
        return credit;
    }

    private Credit createPayments(Credit credit) {
        List<Payment> payments = new ArrayList();

        for (int i = 0; i < credit.getTerms(); i++) {
            Double amount = credit.getAmount() / credit.getTerms();

            Integer daysToAdd = 30 * (i + 1);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, daysToAdd);
            Date datePayment = cal.getTime();

            Payment payment = new Payment();
            payment.setPaymentNumber(i + 1);
            payment.setAmount(amount + ((amount / 100) * credit.getRate()));
            payment.setPaymentDate(datePayment);
            payments.add(payment);
        }

        credit.setPayments(payments);

        return credit;
    }

}
