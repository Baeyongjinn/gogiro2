package com.green.gogiro.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopReviewDto {
    @JsonIgnore
    private int ireview;
    private int iuser;
    private int ishop;
    private int star;
    private String review;
    private List<String> pics = new ArrayList<>();
}
