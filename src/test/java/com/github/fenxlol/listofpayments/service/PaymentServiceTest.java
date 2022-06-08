package com.github.fenxlol.listofpayments.service;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.repository.CreditRepository;
import com.github.fenxlol.listofpayments.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentServiceTest {

    private PaymentService paymentServiceUnderTest;

    @BeforeEach
    void setUp() {
        paymentServiceUnderTest = new PaymentService();
        paymentServiceUnderTest.paymentRepository = mock(PaymentRepository.class);
        paymentServiceUnderTest.creditRepository = mock(CreditRepository.class);
    }

    @Test
    void testListOfPayments() {
        // Setup
        // Configure PaymentRepository.findAll(...).
        final Payment payment = new Payment();
        payment.setId(1L);
        payment.setPaymentNumber(1);
        payment.setAmount(27.5);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final Credit credit = new Credit();
        credit.setId(1L);
        credit.setAmount(20.0);
        credit.setTerms(4);
        credit.setRate(2.0);
        credit.setPayments(List.of(new Payment()));
        payment.setCredit(credit);
        final Iterable<Payment> payments = List.of(payment);
        when(paymentServiceUnderTest.paymentRepository.findAll()).thenReturn(payments);

        // Configure CreditRepository.findFirstByPaymentsIn(...).
        final Credit credit1 = new Credit();
        credit1.setId(1L);
        credit1.setAmount(100.0);
        credit1.setTerms(4);
        credit1.setRate(10.0);
        final Payment payment1 = new Payment();
        payment1.setId(1L);
        payment1.setPaymentNumber(1);
        payment1.setAmount(27.5);
        payment1.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit1.setPayments(List.of(payment1));
        when(paymentServiceUnderTest.creditRepository.findFirstByPaymentsIn(List.of(new Payment())))
                .thenReturn(credit1);

        // Run the test
        final List<Payment> result = paymentServiceUnderTest.listOfPayments();

        // Verify the results
        assertEquals(payment1.getId(), 1L);
        assertEquals(payment1.getPaymentNumber(), 1);
        assertEquals(payment1.getAmount(), 27.5);
        assertEquals(payment1.getPaymentDate(), new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        assertEquals(payment1.getCredit(), null);
    }

    @Test
    void testListOfPayments_PaymentRepositoryReturnsNoItems() {
        // Setup
        when(paymentServiceUnderTest.paymentRepository.findAll()).thenReturn(Collections.emptyList());

        // Configure CreditRepository.findFirstByPaymentsIn(...).
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(0);
        credit.setRate(0.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));
        when(paymentServiceUnderTest.creditRepository.findFirstByPaymentsIn(List.of(new Payment()))).thenReturn(credit);

        // Run the test
        final List<Payment> result = paymentServiceUnderTest.listOfPayments();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }
}
