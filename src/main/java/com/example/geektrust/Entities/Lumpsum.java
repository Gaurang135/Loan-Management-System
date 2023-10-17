package com.example.geektrust.Entities;

import java.util.Objects;

public class Lumpsum{

    private final Integer amount;
    private final Integer emiNumber;

    public Lumpsum(Integer amount, Integer emi) {
        this.amount = amount;
        this.emiNumber = emi;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Lumpsum && equals((Lumpsum) o));
    }

    private boolean equals(Lumpsum lumpsum) {
        return Objects.equals(amount, lumpsum.amount) && Objects.equals(emiNumber, lumpsum.emiNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, emiNumber);
    }
}
