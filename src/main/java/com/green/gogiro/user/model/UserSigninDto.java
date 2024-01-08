package com.green.gogiro.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "로그인Dto")
public class UserSigninDto {
    @Schema(title = "이메일")
    private String email;
    @Schema(title = "비밀번호")
    private String upw;
}
