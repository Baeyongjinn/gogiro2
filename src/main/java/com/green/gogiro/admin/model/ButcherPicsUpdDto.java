package com.green.gogiro.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class ButcherPicsUpdDto {
    private int ibutcher;
    private List<Integer> ibutPics;
    @JsonIgnore
    private List<String> pics = new ArrayList<>();
    @JsonIgnore
    private List<MultipartFile> files;

}
