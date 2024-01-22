package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CancelReservationDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "예약pk")
    @Min(value = 0, message = "예약pk가 없습니다")
    private int ireser;
}
