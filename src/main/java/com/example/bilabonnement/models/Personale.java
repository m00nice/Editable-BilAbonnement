package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
public class Personale {
    private String brugernavn;
    private String password;
    private int id;
    private String rolle;

    public Personale(String brugernavn, String password, int id, String rolle) {
        this.brugernavn = brugernavn;
        this.password = password;
        this.id = id;
        this.rolle = rolle;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
