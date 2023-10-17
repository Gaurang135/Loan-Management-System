package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.BalanceDto;

public interface IBalanceService {
    BalanceDto getBalance(Bank bank, Borrower borrower, Integer emiCount);
}
