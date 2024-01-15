package com.green.gogiro.community.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class CommunityUpdDto {
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "커뮤니티pk")
    private int iboard;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "내용")
    private String contents;
    @Schema(title = "사진")
    private List<String> pics;
}
