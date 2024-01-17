package com.green.gogiro.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum AuthErrorCode implements ErrorCode{

    VALID_EXIST_USER_ID(HttpStatus.NOT_FOUND,"아이디가 존재하지 않습니다."),
    VALID_PASSWORD(HttpStatus.NOT_FOUND,"비밀번호를 확인해주세요."),
    NEED_SIGNIN(HttpStatus.UNAUTHORIZED,"로그인이 필요합니다."),
    VALID_PAGE(HttpStatus.BAD_REQUEST,"잘못된 페이지가 입력되었습니다"),
    SIZE_PHOTO(HttpStatus.BAD_REQUEST,"사진이 5장 초과 입니다"),
    MUST_PHOTO(HttpStatus.BAD_REQUEST,"사진을 1장 이상 넣어 주세요"),
    NOT_EMAIL(HttpStatus.BAD_REQUEST,"아이디를 입력해주세요"),
    NOT_PASSWORD(HttpStatus.BAD_REQUEST,"비밀번호를 입력해 주세요"),
    NOT_NAME(HttpStatus.BAD_REQUEST,"이름을 입력해주세요"),
    NOT_NICK_NAME(HttpStatus.BAD_REQUEST,"닉네임을 입력해 주세요"),
    NOT_GENDER(HttpStatus.BAD_REQUEST,"성별을 선택해 주세요"),
    NOT_TEL(HttpStatus.BAD_REQUEST,"전화번호를 입력해 주세요"),
    NOT_STAR(HttpStatus.BAD_REQUEST,"별점을 선택해 주세요"),
    NOT_COMMUNITY_TITLE(HttpStatus.BAD_REQUEST,"제목을 입력해 주세요"),
    NOT_CONTENT(HttpStatus.BAD_REQUEST,"내용을 입력해 주세요"),
    VALID_SHOP(HttpStatus.NOT_FOUND,"존재 하지 않는 식당(정육점)입니다."),
    CHECK_SHOP(HttpStatus.BAD_REQUEST,"식당이 일치하지 않습니다."),
    NOT_COMMUNITY(HttpStatus.NOT_FOUND, "잘못된 등록입니다."),
    NOT_DATE(HttpStatus.BAD_REQUEST, "예약날짜를 입력해 주세요."),
    NOT_COMMUNITY_CHECK(HttpStatus.NOT_FOUND, "등록된 글을 찾을 수 없습니다"),
    NOT_COMMUNITY_ENTITY(HttpStatus.BAD_REQUEST, "다른 유저의 게시글입니다"),


    NOT_FOUND_REFRESH_TOKEN(HttpStatus.NOT_FOUND, "refresh-token이 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    AuthErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
