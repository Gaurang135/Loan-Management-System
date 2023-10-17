package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;

public interface IPaymentManager {

    void updateLumpSum(Borrower borrower, Bank bank, Lumpsum lumpsum);

}
