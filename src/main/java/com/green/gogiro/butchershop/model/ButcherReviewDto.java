package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ButcherReviewDto {
    @JsonIgnore
    private int ireview;
    @JsonIgnore
    private int iuser;

    private int ibutcher;
    private int star;
    private String review;
    private List<String> pics;
}
