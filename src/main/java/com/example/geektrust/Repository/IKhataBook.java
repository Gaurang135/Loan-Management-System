package com.example.geektrust.Repository;


import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Entities.Lumpsum;

public interface IKhataBook extends IPaymentManager,ILoanAccountManager {


    @Override
    void saveBorrower(Borrower borrower, Loan loan);

    @Override
    Loan getLoan(Bank bank, Borrower borrower);

    @Override
    void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum);


}
