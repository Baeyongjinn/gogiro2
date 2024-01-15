package com.green.gogiro.community.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommunityCommentInsDto {
    @Schema(title = "커뮤니티pk")
    private int iboard;
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "댓글내용")
    private String contents;
}
