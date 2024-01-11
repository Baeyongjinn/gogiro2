package com.green.gogiro.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopDetailMenu {
    private int price;
    private String menu;
    private String pic;
}
