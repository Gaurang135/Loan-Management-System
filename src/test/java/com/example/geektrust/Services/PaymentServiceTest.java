package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Repository.IKhataBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private PaymentService paymentService;
    private IKhataBook khataBook;

    @BeforeEach
    void setUp() {
        khataBook = mock(IKhataBook.class); // Mock the repository
        paymentService = new PaymentService(khataBook);
    }

    @Test
    void addPayment() {
        // Arrange
        Bank bank = new Bank("ABC Bank");
        Borrower borrower = new Borrower("John");
        Lumpsum payment = new Lumpsum(1000, 1);

        // Act
        paymentService.addPayment(bank, borrower, payment);

        // Assert
        verify(khataBook).updateLumpSum(eq(borrower), eq(bank), eq(payment));
    }
}
