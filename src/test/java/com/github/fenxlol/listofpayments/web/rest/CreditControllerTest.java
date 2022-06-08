package com.github.fenxlol.listofpayments.web.rest;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.service.CreditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreditControllerTest {

    private CreditController creditControllerUnderTest;

    @BeforeEach
    void setUp() {
        creditControllerUnderTest = new CreditController();
        creditControllerUnderTest.creditService = mock(CreditService.class);
    }

    @Test
    void testListOfCredits() {
        // Setup
        // Configure CreditService.listOfCredits(...).
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
        final List<Credit> credits = List.of(credit);
        when(creditControllerUnderTest.creditService.listOfCredits()).thenReturn(credits);

        // Run the test
        final List<Credit> result = creditControllerUnderTest.listOfCredits();

        // Verify the results
    }

    @Test
    void testListOfCredits_CreditServiceReturnsNoItems() {
        // Setup
        when(creditControllerUnderTest.creditService.listOfCredits()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Credit> result = creditControllerUnderTest.listOfCredits();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testCreateCreditAndPayments() throws Exception {
        // Setup
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

        // Configure CreditService.createCreditAndPayments(...).
        final Credit credit1 = new Credit();
        credit1.setId(0L);
        credit1.setAmount(0.0);
        credit1.setTerms(0);
        credit1.setRate(0.0);
        final Payment payment1 = new Payment();
        payment1.setId(0L);
        payment1.setPaymentNumber(0);
        payment1.setAmount(0.0);
        payment1.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit1.setPayments(List.of(payment1));
        when(creditControllerUnderTest.creditService.createCreditAndPayments(any(Credit.class))).thenReturn(credit1);

        // Run the test
        final Credit result = creditControllerUnderTest.createCreditAndPayments(credit);

        // Verify the results
    }

    @Test
    void testCreateCreditAndPayments_CreditServiceThrowsException() throws Exception {
        // Setup
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

        when(creditControllerUnderTest.creditService.createCreditAndPayments(any(Credit.class)))
                .thenThrow(Exception.class);

        // Run the test
        assertThrows(Exception.class, () -> creditControllerUnderTest.createCreditAndPayments(credit));
    }
}
