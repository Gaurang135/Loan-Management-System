package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;

public interface ILoanAccountManager {
    void saveBorrower(Borrower borrower, Loan loan);

    Loan getLoan(Bank bank, Borrower borrower);
}
