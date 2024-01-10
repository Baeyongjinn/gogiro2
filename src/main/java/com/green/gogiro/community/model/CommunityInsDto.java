package com.green.gogiro.community.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(title = "커뮤니티 등록 Dto")
public class CommunityInsDto {
    @JsonIgnore
    private int iboard;
    private int iuser;
    private String title;
    private String contents;
    private List<String> pics;
}
