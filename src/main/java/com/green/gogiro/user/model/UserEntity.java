package com.green.gogiro.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int iuser;
    private String email;
    private String upw;
    private String nm;
    private String nickname;
    private String birth;
    private String gender;
    private String address;
    private String pic;
    private String createdAt;
}
