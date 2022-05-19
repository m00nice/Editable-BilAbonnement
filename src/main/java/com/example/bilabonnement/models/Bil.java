package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
public class Bil {
    private int årgang;
    private java.lang.String maerke;
    private java.lang.String model;
    private java.lang.String farve;
    private int bil_ID;
    private int kundeID;
    private double pris;
    private int fejl_id;

    public Bil(){
    }
    public Bil(int årgang, String maerke, String model, String farve, int bil_ID, int kundeID, double pris, int fejl_id) {
        this.årgang = årgang;
        this.maerke = maerke;
        this.model = model;
        this.farve = farve;
        this.bil_ID = bil_ID;
        this.kundeID = kundeID;
        this.pris = pris;
        this.fejl_id = fejl_id;

    }

    public Bil(double pris) {
        this.pris = pris;
    }

    public int getÅrgang() {
        return årgang;
    }

    public void setÅrgang(int årgang) {
        this.årgang = årgang;
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

    public int getFejl_id() {
        return fejl_id;
    }

    public void setFejl_id(int fejl_id) {
        this.fejl_id = fejl_id;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "årgang=" + årgang +
                ", mærke='" + maerke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                ", bil_ID=" + bil_ID +
                ", kundeID=" + kundeID +
                ", pris=" + pris +
                ", fejl_id=" + fejl_id +
                '}';
    }
}

