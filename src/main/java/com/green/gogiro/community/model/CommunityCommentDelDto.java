package com.green.gogiro.community.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CommunityCommentDelDto {
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "댓글pk")
    private int icomment;
}
