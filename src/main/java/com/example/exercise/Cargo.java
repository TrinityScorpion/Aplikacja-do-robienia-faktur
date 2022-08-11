package com.example.exercise;

import java.util.Date;

public class Cargo {
    private Category category;
    private String specificDescription;
    private int massOfSinglePackage;
    private int numberOfPackages;
    private Warehouse warehouse;
    private Date arrivalDate;

    @Override
    public String toString() {
        return "Cargo{" +
                "category=" + category +
                ", specificDescription='" + specificDescription + '\'' +
                ", massOfSinglePackage=" + massOfSinglePackage +
                ", numberOfPackages=" + numberOfPackages +
                ", warehouse=" + warehouse +
                ", arrivalDate=" + arrivalDate +
                '}';
    }

    public Cargo(Category category, String specificDescription, int massOfSinglePackage, int numberOfPackages, Warehouse warehouse, Date arrivalDate) {
        this.category = category;
        this.specificDescription = specificDescription;
        this.massOfSinglePackage = massOfSinglePackage;
        this.numberOfPackages = numberOfPackages;
        this.warehouse = warehouse;
        this.arrivalDate = arrivalDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getSpecificDescription() {
        return specificDescription;
    }

    public void setSpecificDescription(String specificDescription) {
        this.specificDescription = specificDescription;
    }

    public int getMassOfSinglePackage() {
        return massOfSinglePackage;
    }

    public void setMassOfSinglePackage(int massOfSinglePackage) {
        this.massOfSinglePackage = massOfSinglePackage;
    }

    public int getNumberOfPackages() {
        return numberOfPackages;
    }

    public void setNumberOfPackages(int numberOfPackages) {
        this.numberOfPackages = numberOfPackages;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
