package com.example.geektrust.Configs;

import com.example.geektrust.Commands.AddPaymentCommand;
import com.example.geektrust.Commands.CreateLoanCommand;
import com.example.geektrust.Commands.GetBalanceCommand;
import com.example.geektrust.Commands.ICommand;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Repository.*;
import com.example.geektrust.Services.*;

import java.util.HashMap;
import java.util.List;

public class ApplicationConfig {

    HashMap<Borrower, List<Loan>> allRecord = new HashMap<>();

    private final ILoanAccountManager loanAccountManager = new LoanAccountManager(allRecord);
    private final IPaymentManager paymentManager = new PaymentManager(allRecord, loanAccountManager);
    private final IKhataBook book = new KhataBook(loanAccountManager,paymentManager);

    private final ILoanService loanService = new LoanService(book);
    private final IBalanceService balanceService = new BalanceService(book);
    private final IPaymentService paymentService = new PaymentService(book);

    private final IService service = new Service(balanceService,loanService,paymentService);

    private final ICommand createLoan = new CreateLoanCommand(service);
    private final ICommand getBalance = new GetBalanceCommand(service);
    private final ICommand registerPayment = new AddPaymentCommand(service);

    private final ComandInvoker comandInvoker = new ComandInvoker();

    public ComandInvoker getComandInvoker() {
        comandInvoker.registerCommand("LOAN", createLoan);
        comandInvoker.registerCommand("BALANCE", getBalance);
        comandInvoker.registerCommand("PAYMENT", registerPayment);
        return comandInvoker;
    }

}
