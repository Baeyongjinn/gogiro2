package com.green.gogiro.community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommunitySelVo {
    private int iboard;
    private int boardNum;
    private int iuser;
    private String writerName;
    private String title;
    private String contents;
    private List<String> pics = new ArrayList<>();

    @JsonIgnore
    private int count;
}
