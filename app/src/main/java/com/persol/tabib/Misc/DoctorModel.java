package com.persol.tabib.Misc;

public class DoctorModel {

    String dname, degree;

    public DoctorModel(String dname, String degree) {
        this.dname = dname;
        this.degree = degree;
    }

    public String getDname() {
        return dname;
    }

    public String getDegree() {
        return degree;
    }
}
