package com.green.gogiro.community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CommunityInsDto {
    @JsonIgnore
    private int iboard;
    private int iuser;
    private String title;
    private String contents;
    private List<String> pics;
}
