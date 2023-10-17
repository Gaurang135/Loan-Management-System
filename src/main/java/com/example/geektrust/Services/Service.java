package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Models.BalanceDto;
import com.example.geektrust.Models.ValuesTransferModule;

public class Service implements IService{

    private final IBalanceService balanceService;
    private final ILoanService loanService;
    private final IPaymentService paymentService;

    public Service(IBalanceService balanceService, ILoanService loanService, IPaymentService paymentService) {
        this.balanceService = balanceService;
        this.loanService = loanService;
        this.paymentService = paymentService;
    }

    @Override
    public BalanceDto getBalance(Bank bank, Borrower borrower, Integer emiCount) {
        return balanceService.getBalance(bank,borrower,emiCount);
    }

    @Override
    public void saveEntry(Bank bank, Borrower borrower, ValuesTransferModule data) {
        loanService.saveEntry(bank,borrower,data);
    }

    @Override
    public void addPayment(Bank bank, Borrower borrower, Lumpsum payment) {
        paymentService.addPayment(bank,borrower,payment);
    }
}
