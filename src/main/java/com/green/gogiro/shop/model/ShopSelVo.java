package com.green.gogiro.shop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopSelVo {
    private int ishop;
    private String name;
    private String location;
    private List<String> pics = new ArrayList<>();
    private String x;
    private String y;
}
