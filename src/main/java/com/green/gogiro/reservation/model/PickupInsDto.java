package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;


@Data
public class PickupInsDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "정육점pk")
    private int ibutcher;
    @Schema(title = "예약날짜",defaultValue = "0000-00-00")
    private String date;
    @Schema(title = "요청 사항")
    private String request;
    @Schema(title = "메뉴pk")
    private List<Integer> ibutMenus;
    @Schema(title = "수량")
    private List<Integer> counts;
    @JsonIgnore
    private int ipickup;
}
