package com.example.bilabonnement.service;
// Forfatter @Martin Anberg
import com.example.bilabonnement.models.Reservation;
import java.util.List;

public class ReservationService {


    public Reservation findReservation(List list, int bilID, int udlejerID){

    }

    public List sortListBpyBil(List list){

    }

    public List createValidReservationList(List list){

    }

    public List createInvalidReservationList(List<Reservation> list){
        List<Reservation> list2 = null;
        while(list.iterator().hasNext()){
            Reservation reservation = list.iterator().next();
            if(!reservation.isValid()){list2.add(reservation);}
        }
    return list2;
    }




    public void validerReservation(Reservation reservation){
        if(reservation.isValid()){reservation.setValid(false);}
        else{reservation.setValid(true);}
    }

}
