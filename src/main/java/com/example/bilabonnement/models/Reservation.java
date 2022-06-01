package com.example.bilabonnement.models;

import java.util.Date;
// Forfatter @Martin Anberg @Tobias Winkel
public class Reservation {

    private int bilID;
    private int kundeID;
    private Date startDato;
    private Date slutDato;
    private boolean valid;
    private int reservationID;

    public Reservation(int bilID, int udlejerID, Date startDato, Date slutDato, boolean valid, int reservationID) {
        this.bilID = bilID;
        this.kundeID = udlejerID;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.valid = valid;
        this.reservationID = reservationID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
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

    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
