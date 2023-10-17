package com.example.geektrust.Models;

import java.util.Objects;

public class ValuesTransferModule {
    private final Double principal;
    private final Double years;
    private final Double ROI;

    public ValuesTransferModule(Double principal, Double years, Double ROI) {
        this.principal = principal;
        this.years = years;
        this.ROI = ROI;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Double getYears() {
        return years;
    }

    public Double getROI() {
        return ROI;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof ValuesTransferModule &&
                Objects.equals(principal, ((ValuesTransferModule) o).principal) &&
                Objects.equals(years, ((ValuesTransferModule) o).years) &&
                Objects.equals(ROI, ((ValuesTransferModule) o).ROI));
    }

    @Override
    public int hashCode() {
        return Objects.hash(principal, years, ROI);
    }

}
