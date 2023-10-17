package com.example.geektrust.Models;

public class BalanceDto {
    private String bankname;
    private String borrowerName;
    private Integer amountpaid;
    private Integer emiRemains;

    public BalanceDto(String bankName, String borrowerName, Integer amountPaid, Integer emiRemains) {
        this.bankname = bankName;
        this.borrowerName = borrowerName;
        this.amountpaid = amountPaid;
        this.emiRemains = emiRemains;
    }


    @Override
    public String toString() {
        return bankname + " " + borrowerName + " " + amountpaid + " " + emiRemains;
    }
}
