package com.example.bilabonnement.models;
// Forfatter @Martin Anberg
import java.util.Date;

public class Reservation {

    private int bilID;
    private int udlejerID;
    private Date startDato;
    private Date slutDato;
    private boolean valid;

    public Reservation(int bilID, int udlejerID, Date startDato, Date slutDato, boolean valid) {
        this.bilID = bilID;
        this.udlejerID = udlejerID;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.valid = valid;
    }

    public int getBilID() {
        return bilID;
    }

    public void setBilID(int bilID) {
        this.bilID = bilID;
    }

    public Date getStartDato() {
        return startDato;
    }

    public void setStartDato(Date startDato) {
        this.startDato = startDato;
    }

    public Date getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(Date slutDato) {
        this.slutDato = slutDato;
    }

    public int getUdlejerID() {
        return udlejerID;
    }

    public void setUdlejerID(int udlejerID) {
        this.udlejerID = udlejerID;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
