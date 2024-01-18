package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReservationInsDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "고기집pk")
    private int ishop;
    @Schema(title = "예약날짜")
    private String date;
    @Schema(title = "요청 사항")
    private String request;
    @Schema(title = "인원수",defaultValue = "1")
    private int headCount;
}
