package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoanAccountManager implements ILoanAccountManager {

    private final HashMap<Borrower, List<Loan>> recordBook;

    public LoanAccountManager(HashMap<Borrower, List<Loan>> recordBook) {
        this.recordBook = recordBook;
    }

    @Override
    public void saveBorrower(Borrower borrower, Loan loan) {
        recordBook.computeIfAbsent(borrower, k -> new ArrayList<>()).add(loan);


    }

    @Override
    public Loan getLoan(Bank bank, Borrower borrower) {

        Loan foundLoan = recordBook.get(borrower).stream()
                .filter(loan -> loan.getBank().getBankName().equals(bank.getBankName()))
                .findFirst().get();

        return foundLoan;
    }

}
