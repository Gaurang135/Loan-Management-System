package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.BalanceDto;
import com.example.geektrust.Services.IService;

import java.util.List;

public class GetBalanceCommand implements ICommand{

    private final IService service;

    private final int BANK_NAME = 1;
    private final int BORROWER_NAME = 2;
    private final int EMI_COUNT = 3;
    public GetBalanceCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME));
        Borrower borrower = new Borrower(tokens.get(BORROWER_NAME));
        int emiCount = Integer.parseInt(tokens.get(EMI_COUNT));
        BalanceDto balance = service.getBalance(bank, borrower, emiCount);
        System.out.println(balance);
    }
}
