package com.persol.tabib.Misc;

public class MedicineModel {

    String name;
    String brand;

    public MedicineModel(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }
}
