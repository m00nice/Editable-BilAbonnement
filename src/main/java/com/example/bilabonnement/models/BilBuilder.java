package com.example.bilabonnement.models;

public class BilBuilder {
    private int aargang;
    private java.lang.String maerke;
    private java.lang.String model;
    private java.lang.String farve;
    private int bil_ID;
    private int kundeID;
    private double pris;
    private String fejl;
    private double fejl_pris;


    public BilBuilder setAargang(int aargang) {
        this.aargang = aargang;
        return this;
    }

    public BilBuilder setMaerke(String maerke) {
        this.maerke = maerke;
        return this;
    }

    public BilBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public BilBuilder setFarve(String farve) {
        this.farve = farve;
        return this;
    }

    public BilBuilder setBil_ID(int bil_ID) {
        this.bil_ID = bil_ID;
        return this;
    }

    public BilBuilder setKundeID(int kundeID) {
        this.kundeID = kundeID;
        return this;
    }

    public BilBuilder setPris(double pris) {
        this.pris = pris;
        return this;
    }

    public BilBuilder setFejl(String fejl) {
        this.fejl = fejl;
        return this;
    }

    public BilBuilder setFejl_pris(double fejl_pris) {
        this.fejl_pris = fejl_pris;
        return this;
    }

    public Bil buildBil(){
        return new Bil(aargang,maerke,model,farve,bil_ID,kundeID,pris,fejl,fejl_pris);
    }
}
