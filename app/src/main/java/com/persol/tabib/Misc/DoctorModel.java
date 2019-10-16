package com.persol.tabib.Misc;

public class DoctorModel {

    String dname, dsepc, ddesig;

    public DoctorModel(String dname, String dsepc, String ddesig) {
        this.dname = dname;
        this.dsepc = dsepc;
        this.ddesig = ddesig;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDsepc() {
        return dsepc;
    }

    public void setDsepc(String dsepc) {
        this.dsepc = dsepc;
    }

    public String getDdesig() {
        return ddesig;
    }

    public void setDdesig(String ddesig) {
        this.ddesig = ddesig;
    }
}
