package com.green.gogiro.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UserSignupDto {
    @JsonIgnore
    private int iuser;
    private String email;
    private String upw;
    private String nm;
    private String nickname;
    private String birth;
    private String gender;
    private String address;
    private String pic;
}
