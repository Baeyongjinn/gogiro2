package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ButcherReviewDto {
    @JsonIgnore
    private int ireview;
    @JsonIgnore
    private int iuser;
    private int ibutcher;
    private int star;
    private String review;
    private List<MultipartFile> pics;
}
