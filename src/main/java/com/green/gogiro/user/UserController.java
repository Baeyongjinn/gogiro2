package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.UserSigninDto;
import com.green.gogiro.user.model.UserSignupDto;
import com.green.gogiro.user.model.UserUpdDto;
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

    @PutMapping("/edit")
    public ResVo updateUser(@RequestBody UserUpdDto dto) {
        return service.updateUser(dto);
    }
}
