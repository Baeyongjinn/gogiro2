package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    public ResVo signup(@RequestBody UserSignupDto dto) {
        return service.signup(dto);
    }

    @PostMapping("/signin")
    public ResVo signin(@RequestBody UserSigninDto dto){
        return service.signin(dto);
    }

    @PutMapping
    public ResVo updateUser(@RequestBody UserUpdDto dto) {
        return service.updateUser(dto);
    }
    @GetMapping("/{iuser}")
    public UserInfoVo selUserInfo(@PathVariable int iuser){
        return service.selUserInfo(iuser);
    }
}
