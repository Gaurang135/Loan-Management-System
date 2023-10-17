package com.example.geektrust.Entities;



public class Emi{

    private final Integer emiCount;
    private final Integer emiCost;

    public Emi(Integer emiCount, Integer emiCost) {
        this.emiCount = emiCount;
        this.emiCost = emiCost;
    }

    public Integer getEmiCount() {
        return emiCount;
    }


    public Integer getEmiCost() {
        return emiCost;
    }

}
