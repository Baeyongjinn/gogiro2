package com.green.gogiro.community.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "커뮤니티 삭제Dto")
public class CommunityDelDto {
    @Schema(title = "유저pk")
    private int iuser;
    @Schema(title = "커뮤니티pk")
    private int iboard;
}
