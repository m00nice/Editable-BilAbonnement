package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
public class Bil {
    private int årgang;
    private java.lang.String mærke;
    private java.lang.String model;
    private java.lang.String farve;
    private int id;
    private int kundeID;
    private double pris;
    private String fejlOgMangler;
    private double prisPåFejl;

    public Bil(int årgang, String mærke, String model, String farve, int id, int kundeID, double pris, String fejlOgMangler, double prisPåFejl) {
        this.årgang = årgang;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
        this.id = id;
        this.kundeID = kundeID;
        this.pris = pris;
        this.fejlOgMangler = fejlOgMangler;
        this.prisPåFejl = prisPåFejl;
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

    public String getFejlOgMangler() {
        return fejlOgMangler;
    }

    public void setFejlOgMangler(String fejlOgMangler) {
        this.fejlOgMangler = fejlOgMangler;
    }

    public double getPrisPåFejl() {
        return prisPåFejl;
    }

    public void setPrisPåFejl(double prisPåFejl) {
        this.prisPåFejl = prisPåFejl;
    }

    @Override
    public String toString() {
        return "Bil{" +
                "årgang=" + årgang +
                ", mærke='" + mærke + '\'' +
                ", model='" + model + '\'' +
                ", farve='" + farve + '\'' +
                ", id=" + id +
                ", kundeID=" + kundeID +
                ", pris=" + pris +
                ", fejlOgMangler='" + fejlOgMangler + '\'' +
                ", prisPåFejl=" + prisPåFejl +
                '}';
    }
}

