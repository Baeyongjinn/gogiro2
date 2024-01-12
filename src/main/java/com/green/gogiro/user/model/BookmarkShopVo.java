package com.green.gogiro.user.model;

import lombok.Data;

@Data
public class BookmarkShopVo {
    private int imeat;//0: 정육점
    private int ishop;
    private String name;
    private String information;
    private String location;
    private String x;
    private String y;
    private String createdAt;
    private int count;
}
