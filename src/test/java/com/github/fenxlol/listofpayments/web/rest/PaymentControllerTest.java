package com.github.fenxlol.listofpayments.web.rest;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentControllerTest {

    private PaymentController paymentControllerUnderTest;

    @BeforeEach
    void setUp() {
        paymentControllerUnderTest = new PaymentController();
        paymentControllerUnderTest.paymentService = mock(PaymentService.class);
    }

    @Test
    void testListOfPayments() {
        // Setup
        // Configure PaymentService.listOfPayments(...).
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(0);
        credit.setRate(0.0);
        credit.setPayments(List.of(new Payment()));
        payment.setCredit(credit);
        final List<Payment> payments = List.of(payment);
        when(paymentControllerUnderTest.paymentService.listOfPayments()).thenReturn(payments);

        // Run the test
        final List<Payment> result = paymentControllerUnderTest.listOfPayments();

        // Verify the results
    }

    @Test
    void testListOfPayments_PaymentServiceReturnsNoItems() {
        // Setup
        when(paymentControllerUnderTest.paymentService.listOfPayments()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Payment> result = paymentControllerUnderTest.listOfPayments();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }
}
