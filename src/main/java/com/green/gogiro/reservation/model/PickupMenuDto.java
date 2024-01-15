package com.green.gogiro.reservation.model;



import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PickupMenuDto {
    @Schema(title = "픽업pk")
    private int ipickup;
    @Schema(title = "메뉴pk")
    private int ibutMenu;
    @Schema(title = "수량")
    private int count;
}
