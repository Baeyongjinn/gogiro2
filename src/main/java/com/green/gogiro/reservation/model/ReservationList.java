package com.green.gogiro.reservation.model;

import lombok.Data;

@Data
public class ReservationList {
    private int checkShop;//(가게구분0: 식당, 1: 정육점)
    private int ireser;//(예약pk)
    private int ishop;//(식당pk)
    private String date;//(예약 시간)
    private String request;//(요청 사항)
    private int cofirm;//(예약 및 픽업 승인)
}
