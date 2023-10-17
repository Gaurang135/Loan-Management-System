package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Services.IService;


import java.util.List;

public class AddPaymentCommand implements ICommand{

    private final IService service;

    private final int BANK_NAME = 1;
    private final int BORROWER_NAME = 2;
    private final int PAYMENT_AMOUNT = 3;
    private final int EMI_NUMBER = 4;


    public AddPaymentCommand(IService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME));
        Borrower borrower = new Borrower(tokens.get(BORROWER_NAME));
        Integer amountPaid = Integer.valueOf(tokens.get(PAYMENT_AMOUNT));
        Integer emiNumber = Integer.valueOf(tokens.get(EMI_NUMBER));
        Lumpsum payment = new Lumpsum(amountPaid,emiNumber);
        service.addPayment(bank,borrower,payment);
    }
}
