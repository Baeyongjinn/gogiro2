package com.green.gogiro.reservation.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CancelReservationDto {
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "예약pk")
    private int ireser;
}
