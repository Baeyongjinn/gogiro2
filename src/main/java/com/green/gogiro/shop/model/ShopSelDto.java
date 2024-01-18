package com.green.gogiro.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ShopSelDto {
    @Schema(title = "페이지", defaultValue = "1")
    private int page;

    @Schema(title = "검색",defaultValue = " ")
    private String search;

    @Schema(title = "고기 분류",defaultValue = "0")
    private int category;

    @JsonIgnore
    private int startIdx;

    @JsonIgnore
    private final int rowCount = 10;

    public void setPage(int page){
        this.page = page;
        this.startIdx = (this.page -1) * rowCount;
    }
}
