package com.example.geektrust.Commands;

import com.example.geektrust.Commands.AddPaymentCommand;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Services.IService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AddPaymentCommandTest {

    private AddPaymentCommand addPaymentCommand;
    private IService service;

    @BeforeEach
    void setUp() {
        service = mock(IService.class); // Mock the service
        addPaymentCommand = new AddPaymentCommand(service);
    }

    @Test
    void execute() {
        // Arrange
        List<String> tokens = new ArrayList<>();
        tokens.add("PAYMENT");
        tokens.add("BankName");
        tokens.add("BorrowerName");
        tokens.add("1000"); // Payment amount
        tokens.add("1");    // EMI number

        Bank expectedBank = new Bank("BankName");
        Borrower expectedBorrower = new Borrower("BorrowerName");
        Lumpsum expectedPayment = new Lumpsum(Integer.valueOf(tokens.get(3)),Integer.valueOf(tokens.get(4)));

        // Act
        addPaymentCommand.execute(tokens);

        // Assert
        verify(service).addPayment(eq(expectedBank), eq(expectedBorrower), eq(expectedPayment));
    }
}
