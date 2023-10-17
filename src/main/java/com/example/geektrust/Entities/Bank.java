package com.example.geektrust.Entities;

import java.util.Objects;

public class Bank {

    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }


    public String getBankName() {
        return bankName;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Bank && Objects.equals(bankName, ((Bank) o).bankName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName);
    }
}
