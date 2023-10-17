package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.ValuesTransferModule;

public interface ILoanService {
    void saveEntry(Bank bank, Borrower borrower, ValuesTransferModule data);
}
