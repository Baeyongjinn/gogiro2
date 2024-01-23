package com.green.gogiro.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.gogiro.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;


@Data
public class PickupInsDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "정육점pk")
    @Min(value = 1)
    private int ibutcher;
    @Schema(title = "예약날짜")
    @Pattern(regexp= Const.REGEXP_DATE_TYPE5, message= "날짜 형식이 올바르지 않습니다")
    @NotBlank
    private String date;
    @Schema(title = "요청 사항")
    private String request;
    @Schema(title = "메뉴pk")
    @NotNull(message = "메뉴를 입력해주세요")
    @Size(min= 1)
    private List<PickupMenuDto> menus;
    @JsonIgnore
    private int ipickup;
}
