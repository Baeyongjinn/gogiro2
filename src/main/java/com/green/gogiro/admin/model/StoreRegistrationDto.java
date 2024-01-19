package com.green.gogiro.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class StoreRegistrationDto {
    @JsonIgnore
    private int ishop;

    private int imeat;
    private String name;
    private String location;
    private String open;
    private String tel;
    private String x;
    private String y;
    private List<MultipartFile> pics = new ArrayList<>();
}
