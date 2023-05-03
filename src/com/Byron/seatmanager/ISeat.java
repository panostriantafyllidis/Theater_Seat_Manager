package com.Byron.seatmanager;

public interface ISeat {
    boolean reserve() throws IsReservedException;
    boolean cancel() throws  IsNotReservedException;

}
