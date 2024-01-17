package com.green.gogiro.community.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommunityPicsInsDto {
    private int iboard;
    private List<String> pics = new ArrayList<>();
}
