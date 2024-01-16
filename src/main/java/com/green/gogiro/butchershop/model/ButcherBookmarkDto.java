package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ButcherBookmarkDto {
    private int iuser;
    private int ibutcher;
    @JsonIgnore
    private boolean on;

}
