package com.green.gogiro.butchershop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailMenu {
    private int price;
    private String menu;
    private String pic;
}
