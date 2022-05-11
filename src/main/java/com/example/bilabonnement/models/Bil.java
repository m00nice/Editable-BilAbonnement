package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
public class Bil {
    private int årgang;
    private java.lang.String mærke;
    private java.lang.String model;
    private java.lang.String farve;
    private int id;
    private int udlejerID;
    private double pris;

    public Bil(int årgang, String mærke, String model, String farve, int id, int udlejerID, double pris) {
        this.årgang = årgang;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
        this.id = id;
        this.udlejerID = udlejerID;
        this.pris = pris;
    }

    public int getÅrgang() {
        return årgang;
    }

    public void setÅrgang(int årgang) {
        this.årgang = årgang;
    }

    public java.lang.String getMærke() {
        return mærke;
    }

    public void setMærke(java.lang.String mærke) {
        this.mærke = mærke;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUdlejerID() {
        return udlejerID;
    }

    public void setUdlejerID(int udlejerID) {
        this.udlejerID = udlejerID;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}

