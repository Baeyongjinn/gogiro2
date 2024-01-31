package com.green.gogiro.reservation.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReviewPicsInsVo {
    private int ireview;
    private List<String> pics = new ArrayList<>();
}
