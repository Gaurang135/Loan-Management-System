package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Models.ValuesTransferModule;
import com.example.geektrust.Services.IService;

import java.util.List;

public class CreateLoanCommand implements ICommand{

    private final IService service;
    private final int BANK_NAME = 1;
    private final int BORROWER_NAME = 2;
    private final int PRINCIPAL_AMOUNT = 3;
    private final int YEARS = 4;
    private final int ROI= 5;

    public CreateLoanCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME));
        Borrower borrower = new Borrower(tokens.get(BORROWER_NAME));
        Double principal = Double.valueOf(tokens.get(PRINCIPAL_AMOUNT));
        Double years = Double.valueOf(tokens.get(YEARS));
        Double roi = Double.valueOf(tokens.get(ROI));
        ValuesTransferModule data= new ValuesTransferModule(principal,years,roi);

        service.saveEntry(bank,borrower,data);

    }
}
