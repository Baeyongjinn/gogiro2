package com.green.gogiro.community.model;


import lombok.Data;

@Data
public class CommunityCommentInsDto {
    private int iboard;
    private int iuser;
    private String contents;
}
