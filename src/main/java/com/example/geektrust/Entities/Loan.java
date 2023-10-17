package com.example.geektrust.Entities;

import java.util.List;


public class Loan {

    private final Bank bank;
    private final Borrower borrower;
    private final Emi emi;
    private final Double totalAmountToPay;
    private final LumpSumManager lumpsumManager;

    public Loan(Bank bank, Borrower borrower, Emi emi, Double totalAmountToPay) {
        this.bank = bank;
        this.borrower = borrower;
        this.emi = emi;
        this.totalAmountToPay = totalAmountToPay;
        this.lumpsumManager = new LumpSumManager();
    }

    public Bank getBank() {
        return bank;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Integer getEmiCost() {
        return emi.getEmiCost();
    }

    public Double getTotalAmountToPay() {
        return totalAmountToPay;
    }

    public void addLumpsum(Lumpsum lumpsum) {
        lumpsumManager.addLumpsum(lumpsum);
    }

    public List<Lumpsum> getLumpSumBeforeEmi(Integer currentEmiCount) {
        return lumpsumManager.getLumpSumBeforeEmi(currentEmiCount);
    }

    public Boolean isLumpsumBeforeEmi(Integer currentEmiCount) {
        return lumpsumManager.isLumpsumBeforeEmi(currentEmiCount);
    }
}
