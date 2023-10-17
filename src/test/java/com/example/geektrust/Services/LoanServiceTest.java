package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Emi;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Models.ValuesTransferModule;
import com.example.geektrust.Repository.IKhataBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceTest {

    private LoanService loanService;
    private IKhataBook records;
    private final int NO_OF_MONTHS_PER_YEAR = 12;
    private final int ROI_TO_NORMAL = 100;

    @BeforeEach
    void setUp() {
        records = mock(IKhataBook.class); // Mock the repository
        loanService = mock(LoanService.class);
    }

    @Test
    void saveEntry() {
        // Arrange
        Bank bank = new Bank("ABC Bank");
        Borrower borrower = new Borrower("John");
        ValuesTransferModule data = new ValuesTransferModule(10000.0, 5.0, 10.0); // Principal, years, ROI

        // Mock the behavior for calculateTotalAmountToPay and calculateFinalEMI
        doReturn(15000.0).when(loanService).calculateTotalAmountToPay(data);
        doReturn(new Emi(60, 250)).when(loanService).calculateFinalEMI(15000.0, 5.0);

        // Act
        loanService.saveEntry(bank, borrower, data);

        // Assert
        Loan expectedLoan = new Loan(bank, borrower, new Emi(60, 250), 15000.0);
//        verify(records).saveBorrower(eq(borrower), eq(expectedLoan));
    }


}
