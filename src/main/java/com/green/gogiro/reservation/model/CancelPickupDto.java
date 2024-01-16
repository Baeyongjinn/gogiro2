package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CancelPickupDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "픽업pk")
    private int ipickup;
}
