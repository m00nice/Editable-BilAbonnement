package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
public class Bil {
    private int aargang;
    private java.lang.String maerke;
    private java.lang.String model;
    private java.lang.String farve;
    private int bil_ID;
    private int kundeID;
    private double pris;
    private String fejl;
    private double fejl_pris;


    public Bil(int aargang, String maerke, String model, String farve, int bil_ID, int kundeID, double pris, String fejl, double fejl_pris) {
        this.aargang = aargang;
        this.maerke = maerke;
        this.model = model;
        this.farve = farve;
        this.bil_ID = bil_ID;
        this.kundeID = kundeID;
        this.pris = pris;
        this.fejl = fejl;
        this.fejl_pris = fejl_pris;

    }

    public String getFejl() {
        return fejl;
    }

    public void setFejl(String fejl) {
        this.fejl = fejl;
    }

    public double getFejl_pris() {
        return fejl_pris;
    }

    public void setFejl_pris(double fejl_pris) {
        this.fejl_pris = fejl_pris;
    }

    public int getAargang() {
        return aargang;
    }

    public void setAargang(int aargang) {
        this.aargang = aargang;
    }

    public java.lang.String getMaerke() {
        return maerke;
    }

    public void setMaerke(java.lang.String maerke) {
        this.maerke = maerke;
    }

    public java.lang.String getModel() {
        return model;
    }

    public void setModel(java.lang.String model) {
        this.model = model;
    }

    public java.lang.String getFarve() {
        return farve;
    }

    public void setFarve(java.lang.String farve) {
        this.farve = farve;
    }

    public int getBil_ID() {
        return bil_ID;
    }

    public void setBil_ID(int bil_ID) {
        this.bil_ID = bil_ID;
    }

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }


    @Override
    public String toString() {
        return "Bil{" +
                "årgang=" + aargang +
                ", mærke='" + maerke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                ", bil_ID=" + bil_ID +
                ", kundeID=" + kundeID +
                ", pris=" + pris +
                ", fejl_id=" + fejl +
                '}';
    }
}

