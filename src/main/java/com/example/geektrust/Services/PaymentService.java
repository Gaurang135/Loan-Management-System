package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Repository.IKhataBook;

public class PaymentService implements IPaymentService {
    private final IKhataBook khataBook;

    public PaymentService(IKhataBook khataBook) {
        this.khataBook = khataBook;
    }

    public void addPayment(Bank bank, Borrower borrower, Lumpsum payment) {
        khataBook.updateLumpSum(borrower,bank,payment);
    }

}
