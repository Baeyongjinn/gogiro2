package com.green.gogiro.reservation.model;

import lombok.Data;

@Data
public class ReservationInsDto {
    private int iuser;
    private int ishop;
    private String date;
    private String request;
    private int headCount;
}
