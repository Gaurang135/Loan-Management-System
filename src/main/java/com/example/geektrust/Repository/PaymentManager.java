package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Entities.Lumpsum;

import java.util.HashMap;
import java.util.List;

public class PaymentManager implements IPaymentManager{

    private final HashMap<Borrower, List<Loan>> recordBook;

    private final ILoanAccountManager loanAccountManager;

    public PaymentManager(HashMap<Borrower, List<Loan>> recordBook, ILoanAccountManager loanAccountManager) {
        this.recordBook = recordBook;
        this.loanAccountManager = loanAccountManager;
    }

    @Override
    public void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum) {

        Loan loan = loanAccountManager.getLoan(bank, borrower);

        loan.addLumpsum(lumpsum);

    }
}
