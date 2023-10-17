package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Entities.Lumpsum;


public class KhataBook implements IKhataBook{

    private final ILoanAccountManager recordManager;
    private final IPaymentManager lumpsumManager;

    public KhataBook(ILoanAccountManager recordManager, IPaymentManager lumpsumManager) {
        this.recordManager = recordManager;
        this.lumpsumManager = lumpsumManager;
    }

    @Override
    public void saveBorrower(Borrower borrower, Loan loan) {
        recordManager.saveBorrower(borrower,loan);
    }

    @Override
    public Loan getLoan(Bank bank, Borrower borrower) {
        return recordManager.getLoan(bank, borrower);
    }

    @Override
    public void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum) {
        lumpsumManager.updateLumpSum(borrower,bank,lumpsum);
    }
}
