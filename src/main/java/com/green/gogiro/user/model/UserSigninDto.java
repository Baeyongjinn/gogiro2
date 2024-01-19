package com.green.gogiro.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "로그인Dto")
public class UserSigninDto {
    @Schema(title = "이메일",defaultValue = "dd11@naver.com")
    private String email;
    @Schema(title = "비밀번호",defaultValue = "1212")
    private String upw;
}
