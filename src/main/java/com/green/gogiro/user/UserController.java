package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;


    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "회원가입 처리")
    public ResVo signup(@RequestPart(required = false) MultipartFile pic,
                        @RequestPart UserSignupDto dto) {
        if(pic!=null) {
            dto.setFile(pic);
        }
        return service.signup(dto);
    }

    @PostMapping("/signin")
    @Operation(summary = "로그인", description = "로그인 처리")
    public UserSignVo signin(HttpServletRequest req,
                        HttpServletResponse res,
                        @RequestBody UserSigninDto dto) {
        return service.signin(req,res,dto);
    }

    @PostMapping("/signout")
    @Operation(summary = "로그아웃", description = "로그아웃 처리")
    public ResVo postSignout( HttpServletResponse res) {
        return service.signout(res);
    }

    @GetMapping("/refresh-token")
    @Operation(summary = "리프레쉬토큰 발급",description = "리프레쉬토큰 발급 처리")
    public UserSignVo getRefreshToken(HttpServletRequest req) {
        return service.getRefreshToken(req);
    }

    @PutMapping
    @Operation(summary = "회원정보 수정", description = "회원정보 수정 처리")
    public ResVo updateUser(@RequestPart(required = false) MultipartFile pic,
                            @RequestPart UserUpdDto dto) {
        if(pic!=null) {
            dto.setFile(pic);
        }
        return service.updateUser(dto);
    }

    @GetMapping("")
    @Operation(summary = "유저 정보 보기", description = "유저 정보 보기 처리")
    public UserInfoVo selUserInfo() {
        return service.selUserInfo();
    }

    @GetMapping("/reservation")
    @Operation(summary = "예약 및 픽업 리스트", description = "회원이 등록한 예약 및 픽업 정보를 리스트로 처리")
    public List<ReservationVo> getReservation(UserMyPageDto dto) {
        return service.getReservation(dto);
    }

    @GetMapping("/review")
    @Operation(summary = "가게 후기 리스트", description = "회원이 작성한 후기 정보를 리스트로 처리")
    public List<ReviewVo> getUserReview(UserMyPageDto dto) {
        return service.getUserReview(dto);
    }

    @GetMapping("/bookmark")
    @Operation(summary = "북마크 리스트", description = "회원이 북마크 등록한 가게 정보를 리스트로 처리")
    public List<BookmarkShopVo> getUserBookmark(UserMyPageDto dto) {
        return service.getUserBookmark(dto);
    }

    @DeleteMapping("/review")
    @Operation(summary = "가게 후기 삭제", description = "회원이 작성한 가게 후기 삭제 처리")
    public ResVo delShopReview(@RequestBody ReviewDelDto dto) {
        return service.delShopReview(dto);
    }
}
