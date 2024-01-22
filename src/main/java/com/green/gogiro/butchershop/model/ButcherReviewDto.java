package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Min(value = 1)
    @Max(value = 5,message = "별점은 최대 5점 입니다")
    private int star;
    @Schema(title = "리뷰")
    @NotBlank
    @Size(min = 1,max = 50)
    private String review;
    @Schema(title = "리뷰 사진",description = "최대 5장")
    @JsonIgnore
    private List<MultipartFile> pics;
}
