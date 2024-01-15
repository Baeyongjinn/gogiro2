package com.green.gogiro.community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "커뮤니티 등록 Dto")
public class CommunityInsDto {
    @JsonIgnore
    private int iboard;

    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "제목")
    private String title;
    @Schema(title = "내용")
    private String contents;
    @Schema(title = "사진")
    private List<String> pics;
}
