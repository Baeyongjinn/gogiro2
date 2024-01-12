package com.green.gogiro.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopReviewDetail {
    @JsonIgnore
    private int ishop;
    private int ireview;
    private String nickname;
    private int star;
    private String review;
    private List<String> pic = new ArrayList<>();
}
