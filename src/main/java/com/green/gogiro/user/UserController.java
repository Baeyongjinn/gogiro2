package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserInfoVo selUserInfo(@PathVariable @RequestParam("유저pk") int iuser){
        return service.selUserInfo(iuser);
    }

    @GetMapping("/reservation/{iuser}")
    @Operation(summary = "예약 및 픽업 리스트",description = "회원이 등록한 예약 및 픽업 정보를 리스트로 처리")
    public List<ReservationVo> getReservation(@RequestBody UserMyPageDto dto){
        return service.getReservation(dto);
    }

    @GetMapping("/review/{iuser}")
    @Operation(summary = "가게 후기 리스트",description = "회원이 작성한 후기 정보를 리스트로 처리")
    public List<ReviewVo> getUserReview(@RequestBody UserMyPageDto dto){
        return service.getUserReview(dto);
    }

    @GetMapping("/bookmark/{iuser}")
    @Operation(summary = "북마크 리스트",description = "회원이 북마크 등록한 가게 정보를 리스트로 처리")
    public List<BookmarkShopVo> getUserBookmark(@RequestBody UserMyPageDto dto){
        return service.getUserBookmark(dto);
    }
}
