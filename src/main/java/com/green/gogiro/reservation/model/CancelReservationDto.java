package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CancelReservationDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "예약pk")
    private int ireser;
}
