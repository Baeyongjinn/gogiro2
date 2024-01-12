package com.green.gogiro.butchershop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDetail {
    @JsonIgnore
    private int ibutcher;

    private int ireview;
    private String nickname;
    private int star;
    private String review;
    private List<String> pic = new ArrayList<>();
}
