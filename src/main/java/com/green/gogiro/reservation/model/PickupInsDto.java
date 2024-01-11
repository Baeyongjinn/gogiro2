package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;


@Data
public class PickupInsDto {
    private int iuser;
    private int ibutcher;
    private String date;
    private String request;
    @JsonIgnore
    private int ipickup;
    private List<PickupMenuDto> menus;
}
