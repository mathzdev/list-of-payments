package com.github.fenxlol.listofpayments.service;

import com.github.fenxlol.listofpayments.domain.Credit;
import com.github.fenxlol.listofpayments.domain.Payment;
import com.github.fenxlol.listofpayments.repository.CreditRepository;
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

class CreditServiceTest {

    private CreditService creditServiceUnderTest;

    @BeforeEach
    void setUp() {
        creditServiceUnderTest = new CreditService();
        creditServiceUnderTest.creditRepository = mock(CreditRepository.class);
    }

    @Test
    void testListOfCredits() {
        // Setup
        // Configure CreditRepository.findAll(...).
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
        final Iterable<Credit> credits = List.of(credit);
        when(creditServiceUnderTest.creditRepository.findAll()).thenReturn(credits);

        // Run the test
        final List<Credit> result = creditServiceUnderTest.listOfCredits();

        // Verify the results
    }

    @Test
    void testListOfCredits_CreditRepositoryReturnsNoItems() {
        // Setup
        when(creditServiceUnderTest.creditRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Credit> result = creditServiceUnderTest.listOfCredits();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testCreateCreditAndPayments() throws Exception {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(20.0);
        credit.setTerms(4);
        credit.setRate(2.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        final Credit result = creditServiceUnderTest.createCreditAndPayments(credit);

        // Verify the results
        assertEquals(credit1.getId(), 1L);
        assertEquals(credit1.getPayments(), List.of(payment1));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException() {
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

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException_2() {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(4);
        credit.setRate(0.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException_3() {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(4);
        credit.setRate(2.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException_4() {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(53);
        credit.setRate(0.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException_5() {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(0.0);
        credit.setTerms(4);
        credit.setRate(200.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }

    @Test
    void testCreateCreditAndPayments_ThrowsException_6() {
        // Setup
        final Credit credit = new Credit();
        credit.setId(0L);
        credit.setAmount(9999999.0);
        credit.setTerms(4);
        credit.setRate(2.0);
        final Payment payment = new Payment();
        payment.setId(0L);
        payment.setPaymentNumber(0);
        payment.setAmount(0.0);
        payment.setPaymentDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        credit.setPayments(List.of(payment));

        // Configure CreditRepository.save(...).
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
        when(creditServiceUnderTest.creditRepository.save(any(Credit.class))).thenReturn(credit1);

        // Run the test
        assertThrows(Exception.class, () -> creditServiceUnderTest.createCreditAndPayments(credit));
    }
}
