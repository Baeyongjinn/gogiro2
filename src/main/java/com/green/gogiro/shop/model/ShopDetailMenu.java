package com.green.gogiro.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopDetailMenu {
    @JsonIgnore
    private int ishop;
    private int price;
    private String menu;
    private String pic;
}
