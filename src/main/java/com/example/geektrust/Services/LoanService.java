package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Borrower;
import com.example.geektrust.Entities.Emi;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Models.ValuesTransferModule;
import com.example.geektrust.Repository.IKhataBook;


public class LoanService implements ILoanService{
    private final IKhataBook records;

    private final int NO_OF_MONTHS_PER_YEAR = 12;
    private final int ROI_TO_NORMAL = 100;

    public LoanService(IKhataBook records) {
        this.records = records;
    }

    public void saveEntry(Bank bank, Borrower borrower, ValuesTransferModule data){
        Double amountToPay = calculateTotalAmountToPay(data);

        Emi emi = calculateFinalEMI(amountToPay, data.getYears());
        Loan loan = new Loan(bank,borrower,emi,amountToPay);
        records.saveBorrower(borrower,loan);
    }
    Double calculateTotalAmountToPay(ValuesTransferModule data){
        Double rateOfInterest = data.getROI()/ROI_TO_NORMAL;
        Double interest = (data.getPrincipal() * data.getYears() * rateOfInterest);
        Double finalAmount = data.getPrincipal() + interest;
        return finalAmount;
    }

    Emi calculateFinalEMI(Double finalAmountToPay, Double years) {

        Integer totalEmi = (int) Math.ceil(years*NO_OF_MONTHS_PER_YEAR);
        Integer costPerEmi = (int) Math.ceil(finalAmountToPay/totalEmi);
        Emi emi = new Emi(totalEmi,costPerEmi);

        return emi;

    }
}
