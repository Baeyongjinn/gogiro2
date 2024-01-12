package com.green.gogiro.user.model;

import lombok.Data;

import java.util.List;

@Data
public class ReviewVo {
    private int checkShop;//가게구분(0:고기집, 1: 정육점)
    private int ireview;//후기pk
    private int ishop;//가게pk
    private int star;//별점
    private String review;//후기
    private String createdAt;
    private List<String> pics;//(후기 사진)
}
