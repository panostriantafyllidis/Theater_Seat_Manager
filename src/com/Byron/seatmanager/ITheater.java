package com.Byron.seatmanager;


// Methods inside an interface are Public and Abstract
public interface ITheater {
    boolean reserveSeat (String seatNumber) throws IsReservedException;
    boolean cancelReservation (String seatNumber) throws IsNotReservedException;
    void printSeats();
}
