package com.green.gogiro.user.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserUpdDto {
    private int iuser;
    private String nickname;
    private String address;
    @Schema(defaultValue = " ")
    private String pic;
}
