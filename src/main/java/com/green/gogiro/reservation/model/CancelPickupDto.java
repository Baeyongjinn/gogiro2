package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CancelPickupDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "픽업pk")
    @Min(value = 0, message = "픽업pk가 없습니다")
    private int ipickup;
}
