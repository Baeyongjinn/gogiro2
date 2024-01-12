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
    private List<Integer> ibutMenus;
    private List<Integer> counts;
    @JsonIgnore
    private int ipickup;
}
