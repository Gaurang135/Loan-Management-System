package com.example.geektrust.Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LumpSumManager {

    private final List<Lumpsum> lumpsumPayments;

    public LumpSumManager() {
        this.lumpsumPayments = new ArrayList<>();
    }

    public void addLumpsum(Lumpsum lumpsum) {
        lumpsumPayments.add(lumpsum);
    }

    public List<Lumpsum> getLumpSumBeforeEmi(Integer currentEmiCount) {
        return lumpsumPayments.stream()
                .filter(payment -> payment.getEmiNumber() <= currentEmiCount)
                .collect(Collectors.toList());
    }

    public Boolean isLumpsumBeforeEmi(Integer currentEmiCount) {
        return lumpsumPayments.stream()
                .anyMatch(check -> check.getEmiNumber() <= currentEmiCount);
    }

}
