package com.example.geektrust.Services;

import com.example.geektrust.Entities.Lumpsum;
import com.example.geektrust.Models.BalanceDto;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Repository.IKhataBook;


public class BalanceService implements IBalanceService{
    private final IKhataBook records;

    public BalanceService(IKhataBook record) {
        this.records = record;
    }
    public BalanceDto getBalance(Bank bank, Borrower borrower, Integer emiCount) {

        Loan loan = records.getLoan(bank, borrower);


        int emiCost = loan.getEmiCost();
        int amountPaid = calculateAmountPaid(emiCount, loan, emiCost);
        int emiRemains = calculateEmiRemains(loan, amountPaid, emiCost);

        BalanceDto statement = new BalanceDto(
                bank.getBankName(),
                borrower.getuserName(),
                amountPaid,
                emiRemains
        );

        return statement;
    }

    private int calculateAmountPaid(int emiCount, Loan loan, int emiCost) {
        if (!loan.isLumpsumBeforeEmi(emiCount)) {
            return emiCount * emiCost;
        } else {
            int sum = loan.getLumpSumBeforeEmi(emiCount).stream()
                    .mapToInt(Lumpsum::getAmount).sum();
            int amountPaid = emiCount * emiCost + sum;
            return (amountPaid > loan.getTotalAmountToPay())?loan.getTotalAmountToPay().intValue():amountPaid;
        }
    }

    private int calculateEmiRemains(Loan loan, int amountPaid, int emiCost) {
        int remainingAmount = (int)Math.max(0, loan.getTotalAmountToPay() - amountPaid);
        return (int) Math.ceil(remainingAmount / (double) emiCost);
    }



}
