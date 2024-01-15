package com.green.gogiro.reservation.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReservationInsDto {
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "식당pk")
    private int ishop;
    @Schema(title = "예약날짜",defaultValue = "0000-00-00")
    private String date;
    @Schema(title = "요청 사항")
    private String request;
    @Schema(title = "인원수",defaultValue = "1")
    private int headCount;
}
