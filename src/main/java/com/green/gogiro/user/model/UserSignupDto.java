package com.green.gogiro.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "회원가입Dto")
public class UserSignupDto {
    @JsonIgnore
    private int iuser;

    @Schema(title = "이메일")
    private String email;
    @Schema(title = "비밀번호")
    private String upw;
    @Schema(title = "비밀번호 확인")
    private String checkUpw;
    @Schema(title = "이름")
    private String name;
    @Schema(title = "닉네임")
    private String nickname;
    @Schema(title = "생년월일",defaultValue = "0000-00-00")
    private String birth;
    @Schema(title = "성별",description = "'남','여' 로  해야함 '남자','여자' X",defaultValue = "'남','여' 로  해야함 '남자','여자' X")
    private String gender;
    @Schema(title = "주소")
    private String address;
    @Schema(title = "프로필 사진",defaultValue = " ")
    private String pic;
    @Schema(title = "전화번호",defaultValue = " ")
    private String tel;
}
