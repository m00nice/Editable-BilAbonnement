package com.example.bilabonnement.service;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {


    public Reservation findReservation(ArrayList list, int bilID, int udlejerID){
        return null;

   }

    public ArrayList sortListByBil(List list){
        return null;

    }

    public ArrayList createValidReservationList(List list){
        return null;

    }

    public ArrayList createInvalidReservationList(List<Reservation> list){
        ArrayList<Reservation> reservationer = new ArrayList();
        while(list.iterator().hasNext()){
            Reservation reservation = list.iterator().next();
            if(!reservation.isValid()){reservationer.add(reservation);}
        }
    return reservationer;
    }


    public void validerReservation(Reservation reservation){
        if(reservation.isValid()){reservation.setValid(false);}
        else{reservation.setValid(true);}
    }

}
