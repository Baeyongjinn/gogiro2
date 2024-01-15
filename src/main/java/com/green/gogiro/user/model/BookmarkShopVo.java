package com.green.gogiro.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookmarkShopVo {
    @Schema(title = "고기 종류",description = "정육점은 0으로 나옴")
    private int imeat;//0: 정육점
    @Schema(title = "식당pk")
    private int ishop;
    @Schema(title = "상호명")
    private String name;
    @Schema(title = "가게정보")
    private String information;
    @Schema(title = "가게위치")
    private String location;
    @Schema(title = "경도")
    private String x;
    @Schema(title = "위도")
    private String y;
    private String createdAt;
    @Schema(title = "가게 총북마크 수")
    private int count;
}
