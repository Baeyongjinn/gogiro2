package com.green.gogiro.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReservationVo {
    @Schema(title = "가게 구분(0:식당,1:정육점)")
    private int checkShop;//(가게구분0: 식당, 1: 정육점)
    @Schema(title = "예약pk")
    private int ireser;//(예약pk)
    @Schema(title = "식당pk")
    private int ishop;//(식당pk)
    @Schema(title = "예약날짜",defaultValue = "0000-00-00")
    private String date;//(예약 시간)
    @Schema(title = "요청 사항")
    private String request;//(요청 사항)
    @Schema(title = "예약 및 픽업 승인(0:대기, 1: 취소 2: 확정")
    private int cofirm;//(예약 및 픽업 승인)
}
