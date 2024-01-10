package com.green.gogiro.community.model;

import lombok.Data;

import java.util.List;

@Data
public class CommunityUpdDto {
    private int iuser;
    private int iboard;
    private String title;
    private String contents;
    private List<String> pics;
}
