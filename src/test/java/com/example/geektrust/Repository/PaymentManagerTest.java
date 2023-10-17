package com.example.geektrust.Repository;

import com.example.geektrust.Entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentManagerTest {

    private PaymentManager paymentManager;
    private ILoanAccountManager loanAccountManager;

    @BeforeEach
    void setUp() {
        loanAccountManager = mock(ILoanAccountManager.class); // Mock the loan account manager
        HashMap<Borrower, List<Loan>> recordBook = new HashMap<>(); // Create a mock record book
        paymentManager = new PaymentManager(recordBook, loanAccountManager);
    }

    @Test
    void updateLumpSum() {
        // Arrange
        Bank bank = new Bank("ABC Bank");
        Borrower borrower = new Borrower("John");
        Lumpsum lumpsum = new Lumpsum(1000, 1);
        Emi emi = new Emi(5,200);
        Loan loan = new Loan(bank, borrower, emi, 1000.0);

        // Mock the behavior of the loan account manager to return the loan
        when(loanAccountManager.getLoan(eq(bank), eq(borrower))).thenReturn(loan);

        // Act
        paymentManager.updateLumpSum(borrower, bank, lumpsum);
//
//        // Assert
        verify(loanAccountManager).getLoan(eq(bank), eq(borrower));

    }
}
