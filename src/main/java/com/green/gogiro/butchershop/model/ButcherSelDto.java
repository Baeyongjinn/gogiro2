package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ButcherSelDto {
    @Schema(title = "페이지", defaultValue = "1")
    private int page;

    @JsonIgnore
    private int startIdx;

    @JsonIgnore
    private final int rowCount = 10;

    public void setPage(int page){
        this.page = page;
        this.startIdx = (this.page -1) * rowCount;
    }
}
