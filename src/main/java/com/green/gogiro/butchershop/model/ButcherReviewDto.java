package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ButcherReviewDto {
    @JsonIgnore
    private int ireview;
    @JsonIgnore
    private int iuser;
    @Schema(title = "정육점pk")
    private int ibutcher;
    @Schema(title = "별점")
    private int star;
    @Schema(title = "리뷰")
    private String review;
    @Schema(title = "리뷰 사진",description = "최대 5장")
    private List<MultipartFile> pics;
}
