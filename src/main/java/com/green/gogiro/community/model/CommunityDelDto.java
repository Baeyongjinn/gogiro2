package com.green.gogiro.community.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "커뮤니티 삭제Dto")
public class CommunityDelDto {
    private int iuser;
    private int iboard;
}
