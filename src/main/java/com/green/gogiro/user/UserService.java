package com.green.gogiro.user;

import static com.green.gogiro.common.Const.*;

import com.green.gogiro.common.AppProperties;
import com.green.gogiro.common.CookieUtils;
import com.green.gogiro.common.MyFileUtils;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.security.MyPrincipal;
import com.green.gogiro.security.MyUserDetails;
import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final CookieUtils cookeUtils;
    private final AuthenticationFacade authenticationFacade;
    private final MyFileUtils myFileUtils;


    public ResVo signup(UserSignupDto dto) {
        String checkNickname = mapper.checkNickname(dto.getNickname());

        String hashedPw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        dto.setUpw(hashedPw);
        mapper.signupUser(dto);
        int result = dto.getIuser();
        log.info("dto: {}", dto);
        //iuser값 return
        return new ResVo(result);
    }

    //1:성공 , 2:비밀번호 다름, 3:아이디없음
    public UserSignVo signin(HttpServletRequest req,
                             HttpServletResponse res,
                             UserSigninDto dto) {
        UserEntity entity = mapper.userEntity(dto.getEmail());
        if (entity == null) {
            return UserSignVo.builder().result(ID_NULL).build();
        } else if (!passwordEncoder.matches(dto.getUpw(), entity.getUpw())) {
            return UserSignVo.builder().result(PW_FAIL).build();
        }
        MyPrincipal myPrincipal = MyPrincipal.builder()
                .iuser(entity.getIuser())
                .build();
        String at = jwtTokenProvider.generateAccessToken(myPrincipal);
        String rt = jwtTokenProvider.generateRefreshToken(myPrincipal);

        int rtCookieMaxAge = appProperties.getJwt().getRefreshTokenCookieMaxAge();
        cookeUtils.deleteCookie(res, "rt");
        cookeUtils.setCookie(res, "rt", rt, rtCookieMaxAge);

        return UserSignVo.builder()
                .result(SUCCESS)
                .iuser(entity.getIuser())
                .name(entity.getName())
                .pic(entity.getPic())
                .nickname(entity.getNickname())
                .tel(entity.getTel())
                .birth(entity.getBirth())
                .address(entity.getAddress())
                .gender(entity.getGender())
                .accessToken(at)
                .build();
    }
    public ResVo signout(HttpServletResponse res) {
        cookeUtils.deleteCookie(res,"rt");
        return new ResVo(1);
    }

    public UserSignVo getRefreshToken(HttpServletRequest req) {
        Cookie cookie = cookeUtils.getCookie(req,"rt");
        if(cookie == null){
            return UserSignVo.builder().
                    result(FAIL)
                    .accessToken(null)
                    .build();
        }
        String token = cookie.getValue();
        if(!jwtTokenProvider.isValidateToken(token)) {
            return UserSignVo.builder().
                    result(FAIL)
                    .accessToken(null)
                    .build();
        }
        MyUserDetails myUserDetails = (MyUserDetails) jwtTokenProvider.getUserDetailsFromToken(token);
        MyPrincipal myPrincipal = myUserDetails.getMyPrincipal();

        String at = jwtTokenProvider.generateAccessToken(myPrincipal);

        return UserSignVo.builder().
                result(SUCCESS)
                .accessToken(at)
                .build();
    }



    public ResVo updateUser(UserUpdDto dto) {
        String check = mapper.checkNickname(dto.getNickname());
        if(check == null) {
            new ResVo(FAIL);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.updateUser(dto);
        return new ResVo(SUCCESS);
    }

    public UserInfoVo selUserInfo(){
        //UserEntity entity = mapper.userEntity(iuser);
        return mapper.selUserInfo(authenticationFacade.getLoginUserPk());
    }

    public List<ReservationVo> getReservation(UserMyPageDto dto){
        dto.setIuser(authenticationFacade.getLoginUserPk());
        return mapper.selReservation(dto);
    }

    public List<ReviewVo> getUserReview(UserMyPageDto dto){
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<ReviewVo> reviews= mapper.selUserReview(dto);
        List<ReviewPk> reviewPkList= new ArrayList<>();
        Map<ReviewPk, ReviewVo> reviewMap= new HashMap<>();
        for(ReviewVo vo: reviews){
            ReviewPk pk= new ReviewPk(vo.getCheckShop(),vo.getIreview());
            reviewMap.put(pk, vo);
            reviewPkList.add(pk);
        }
        for(ReviewPk pk: reviewPkList){
            List<String> pics= mapper.selUserReviewPic(pk);
            reviewMap.get(pk).setPics(pics);
        }
        return reviews;
    }

    public List<BookmarkShopVo> getUserBookmark(UserMyPageDto dto){
        dto.setIuser(authenticationFacade.getLoginUserPk());
        return mapper.selUserBookmark(dto);
    }

    public ResVo delShopReview(ReviewDelDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.delShopReviewPics(dto.getIreview());
        return new ResVo(mapper.delShopReview(dto));
    }
}
