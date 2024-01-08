package com.green.gogiro.user.model;

import lombok.Data;

@Data
public class UserInfoVo {
    private String email;
    private String name;
    private String nickname;
    private String birth;
    private String gender;
    private String address;
    private String pic;
}
