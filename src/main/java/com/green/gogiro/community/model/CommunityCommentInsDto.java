package com.green.gogiro.community.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommunityCommentInsDto {
    @Schema(title = "커뮤니티pk")
    private int iboard;

    @JsonIgnore
    private int iuser;
    @Schema(title = "댓글내용")
    private String contents;
}
