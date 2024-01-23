package com.green.gogiro.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ShopMenuUpdDto {

    private int imenu;

    private int ishop;
    @NotBlank
    @Size(min = 1, max = 100, message = "100자 이상 작성할 수 없습니다.")
    private String menu;

    private int price;
    @JsonIgnore
    private MultipartFile pic;
    @JsonIgnore
    private String fileNm;

}
