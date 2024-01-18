package com.green.gogiro.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode{


    NOT_EMAIL(HttpStatus.BAD_REQUEST,"아이디를 입력해주세요"),
    REGEXP_EMAIL(HttpStatus.BAD_REQUEST,"이메일 형식이 틀렸습니다"),
    NOT_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호를 입력해 주세요"),
    NOT_NAME(HttpStatus.BAD_REQUEST,"이름을 입력해주세요"),
    NOT_NICK_NAME(HttpStatus.BAD_REQUEST,"닉네임을 입력해 주세요"),
    NOT_GENDER(HttpStatus.BAD_REQUEST,"성별을 선택해 주세요"),
    NOT_TEL(HttpStatus.BAD_REQUEST,"전화번호를 입력해 주세요");


    private final HttpStatus httpStatus;
    private final String message;
}
