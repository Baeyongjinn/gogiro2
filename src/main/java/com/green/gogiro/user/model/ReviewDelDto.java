package com.green.gogiro.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ReviewDelDto {
    @Schema(title="가게구분(0: 고기집 1: 정육점)")
    private int checkShop;
    @Schema(title="리뷰pk")
    private int ireview;
    @JsonIgnore
    private int iuser;
    @JsonIgnore
    private boolean check;

    public void setCheckShop(int checkShop){
        this.checkShop= checkShop;
        this.check= (checkShop==0);
    }
}
