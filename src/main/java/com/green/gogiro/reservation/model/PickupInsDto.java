package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class PickupInsDto {
    private int iuser;
    private int ibutcher;
    private String date;
    private String request;
    @JsonIgnore
    private int ipickup;
    private Map<Integer, Integer> menu;
    @JsonIgnore
    private List<Integer> ibut_menu= new ArrayList();
    @JsonIgnore
    private List<Integer> count= new ArrayList();

    public void setMenu(Map<Integer, Integer> menu){
        menu.entrySet().forEach(map-> {
            ibut_menu.add(map.getKey());
            count.add(map.getValue());
        });
    }
}
