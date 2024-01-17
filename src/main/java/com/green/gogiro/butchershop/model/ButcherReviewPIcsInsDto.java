package com.green.gogiro.butchershop.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ButcherReviewPIcsInsDto {
    private int ireview;
    private List<String> pics = new ArrayList<>();
}
