package com.green.gogiro.user.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Schema(title = "유저정보 수정 Dto")
public class UserUpdDto {
    @JsonIgnore
    private int iuser;
    @Schema(title = "닉네임")
    private String nickname;
    @Schema(title = "주소")
    private String address;
    @Schema(title = "프로필 사진", defaultValue = " ")
    private String pic;
    @Schema(title = "전화번호", defaultValue = " ")
    private String tel;
    @JsonIgnore
    private MultipartFile file;
}
