package com.green.gogiro.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.gogiro.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopReviewDto {
    @JsonIgnore
    private int ireview;

    @JsonIgnore
    private int iuser;

    @Schema(title = "고기집pk")
    private int ishop;

    @Schema(title = "별점")
    @Min(1)
    @Max(value = 5, message = "별점은 최대 5점입니다.")
    private int star;

    @Schema(title = "리뷰")
    @NotBlank(message = "내용을 입력해주세요.")
    @Size(min = 1, max = 50, message = "50자 초과 작성 할 수 없습니다.")
    private String review;

    @JsonIgnore
    @Schema(title = "사진",description = "최대 5장")
    private List<MultipartFile> pics;
}
