package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;

public interface IPaymentService {
    void addPayment(Bank bank, Borrower borrower, Lumpsum payment);
}
