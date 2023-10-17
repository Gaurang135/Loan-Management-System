package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.ValuesTransferModule;
import com.example.geektrust.Services.IService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CreateLoanCommandTest {

    private CreateLoanCommand createLoanCommand;
    private IService service;

    @BeforeEach
    void setUp() {
        service = mock(IService.class); // Mock the service
        createLoanCommand = new CreateLoanCommand(service);
    }

    @Test
    void execute() {
        // Arrange
        List<String> tokens = new ArrayList<>();
        tokens.add("LOAN");
        tokens.add("BankName");
        tokens.add("BorrowerName");
        tokens.add("1000.0"); // Principal amount
        tokens.add("5.0");    // Years
        tokens.add("0.05");   // ROI

        Bank expectedBank = new Bank("BankName");
        Borrower expectedBorrower = new Borrower("BorrowerName");
        ValuesTransferModule expectedData = new ValuesTransferModule(Double.valueOf(tokens.get(3)), Double.valueOf(tokens.get(4)), Double.valueOf(tokens.get(5)));

        // Act
        createLoanCommand.execute(tokens);

        // Assert
        verify(service).saveEntry(eq(expectedBank), eq(expectedBorrower), eq(expectedData));
    }
}
