package com.green.gogiro.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class ButcherPicVo {
    private int ibutcher;
    private List<String> pics;
}
