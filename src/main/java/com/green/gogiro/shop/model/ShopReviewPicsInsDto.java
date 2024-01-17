package com.green.gogiro.shop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopReviewPicsInsDto {
    private int ireview;
    private List<String> pics = new ArrayList<>();
}
