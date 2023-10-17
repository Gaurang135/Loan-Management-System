package com.example.geektrust.Entities;


import java.util.Objects;

public class Borrower{

    private final String userName;


    public Borrower(String userName) {
        this.userName = userName;
    }

    public String getuserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Borrower && Objects.equals(userName, ((Borrower) o).userName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }


}
