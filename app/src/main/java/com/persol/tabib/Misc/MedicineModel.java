package com.persol.tabib.Misc;

public class MedicineModel {

    String mname, mbrand, mdesc, mprice;

    public MedicineModel(String mname, String mbrand, String mdesc, String mprice) {
        this.mname = mname;
        this.mbrand = mbrand;
        this.mdesc = mdesc;
        this.mprice = mprice;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMbrand() {
        return mbrand;
    }

    public void setMbrand(String mbrand) {
        this.mbrand = mbrand;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    public String getMprice() {
        return mprice;
    }

    public void setMprice(String mprice) {
        this.mprice = mprice;
    }
}
