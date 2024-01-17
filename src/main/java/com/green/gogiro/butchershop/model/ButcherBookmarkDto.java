package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ButcherBookmarkDto {
    @JsonIgnore
    private int iuser;
    private int ibutcher;
    @JsonIgnore
    private boolean on;
}
