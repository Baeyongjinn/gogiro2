package com.green.gogiro.admin.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ButcherPicVo {
    private int ibutcher;
    private List<String> pics= new ArrayList<>();
}
