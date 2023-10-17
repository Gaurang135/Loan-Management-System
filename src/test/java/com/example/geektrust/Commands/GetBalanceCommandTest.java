package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.BalanceDto;
import com.example.geektrust.Services.IService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GetBalanceCommandTest {

    private GetBalanceCommand getBalanceCommand;
    private IService service;

    @BeforeEach
    void setUp() {
        service = mock(IService.class); // Mock the service
        getBalanceCommand = new GetBalanceCommand(service);
    }

    @Test
    void execute() {
        // Arrange
        List<String> tokens = new ArrayList<>();
        tokens.add("BALANCE");
        tokens.add("BankName");
        tokens.add("BorrowerName");
        tokens.add("5"); // EMI count

        Bank expectedBank = new Bank("BankName");
        Borrower expectedBorrower = new Borrower("BorrowerName");
        int expectedEmiCount = 5;
        BalanceDto expectedBalance = new BalanceDto("BankName", "BorrowerName", 5,5);

        // Mock the behavior of the service
        when(service.getBalance(eq(expectedBank), eq(expectedBorrower), eq(expectedEmiCount)))
                .thenReturn(expectedBalance);

        // Act
        getBalanceCommand.execute(tokens);

        // Assert
        verify(service).getBalance(eq(expectedBank), eq(expectedBorrower), eq(expectedEmiCount));
        // You can add further assertions if needed based on the behavior of your execute method.
    }
}
