package com.green.gogiro.reservation.model;



import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PickupMenuDto {
    private int ipickup;
    private int ibutMenu;
    private int count;
}
