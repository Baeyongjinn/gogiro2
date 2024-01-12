package com.green.gogiro.shop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopDetailVo {
    private int ishop;
    private String name;
    private String location;
    private String information;
    private String x;
    private String y;
    private double star;
    private List<String> pics = new ArrayList<>();
    private List<ShopDetailMenu> menus = new ArrayList<>();
    private List<ShopReviewDetail> reviews = new ArrayList<>();
}
