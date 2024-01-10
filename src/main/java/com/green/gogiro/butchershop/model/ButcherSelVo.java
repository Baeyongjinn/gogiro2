package com.green.gogiro.butchershop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ButcherSelVo {
    private int ibutcher;
    private String name;
    private String location;
    private List<String> pics = new ArrayList<>();
    private String x;
    private String y;
}
