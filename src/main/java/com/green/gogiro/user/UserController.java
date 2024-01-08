package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;


    @PostMapping("/signup")
    @Operation(summary = "회원가입",description = "회원가입 처리")
    public ResVo signup(@RequestBody UserSignupDto dto) {
        return service.signup(dto);
    }

    @PostMapping("/signin")
    @Operation(summary = "로그인",description = "로그인 처리")
    public ResVo signin(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }

    @PutMapping
    @Operation(summary = "회원정보 수정", description = "회원정보 수정 처리")
    public ResVo updateUser(@RequestBody UserUpdDto dto) {
        return service.updateUser(dto);
    }

    @GetMapping("/{iuser}")
    @Operation(summary = "유저 정보 보기",description = "유저 정보 보기 처리")
    public UserInfoVo selUserInfo(@PathVariable int iuser){
        return service.selUserInfo(iuser);
    }
}
