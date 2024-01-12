package com.green.gogiro.butchershop.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ButcherShopDetailVo {
    private int ibutcher;
    private String name;
    private String location;
    private String information;
    private String x;
    private String y;
    private double star;
    private List<String> pics= new ArrayList<>();
    private List<DetailMenu> menus = new ArrayList<>();
    private List<ReviewDetail> reviews = new ArrayList<>();
}

