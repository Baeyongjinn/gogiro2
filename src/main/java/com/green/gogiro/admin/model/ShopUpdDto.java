package com.green.gogiro.admin.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopUpdDto {
    private int ishop;
    private List<Integer> ishopPics;
    private List<String> pics = new ArrayList<>();

    private List<MultipartFile> files = new ArrayList<>();
}
