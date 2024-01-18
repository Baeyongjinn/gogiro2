package com.green.gogiro.user;

import static com.green.gogiro.common.Const.*;

import com.green.gogiro.common.*;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.CommonErrorCode;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.exception.UserErrorCode;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.security.MyPrincipal;
import com.green.gogiro.security.MyUserDetails;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.shop.model.ShopFacilityVo;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;
    private final ShopMapper shopMapper;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final CookieUtils cookeUtils;
    private final AuthenticationFacade authenticationFacade;
    private final MyFileUtils myFileUtils;


    public ResVo signup(UserSignupDto dto) {
        String checkNickname = mapper.checkNickname(dto.getNickname());
        String hashedPw = passwordEncoder.encode(dto.getUpw());
        dto.setUpw(hashedPw);

        if (dto.getEmail() == null ||
                dto.getUpw() == null ||
                dto.getTel() == null ||
                dto.getName() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, dto.getName())
                || dto.getNickname() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, dto.getNickname())
                || dto.getBirth() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, dto.getBirth())
                || dto.getGender() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, dto.getGender())
                || dto.getAddress() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR, dto.getAddress())) {
            throw new RestApiException(CommonErrorCode.INVALID_PARAMETER);
        }

        if(!Pattern.matches(REGEXP_USER_TEL,dto.getTel())) {
            throw new RestApiException(UserErrorCode.REGEXP_TEL);
        }

        if (!Pattern.matches(REGEXP_USER_ID, dto.getEmail())) {
            throw new RestApiException(UserErrorCode.REGEXP_EMAIL);
        }

        if (!Pattern.matches(REGEXP_USER_GENDER, dto.getGender())) {
            throw new RestApiException(UserErrorCode.REGEXP_GENDER);
        }
        if (!Pattern.matches(REGEXP_USER_TEL, dto.getTel())) {
            throw new RestApiException(UserErrorCode.REGEXP_TEL);
        }

        mapper.signupUser(dto);

        if (dto.getFile() != null) {
            String path = "/user/" + dto.getIuser();
            String savedPicFileNm = myFileUtils.transferTo(dto.getFile(), path);
            dto.setPic(savedPicFileNm);
            mapper.updUserPic(dto);
        }

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
            throw new RestApiException(AuthErrorCode.INVALID_EXIST_USER_ID);
        } else if (!passwordEncoder.matches(dto.getUpw(), entity.getUpw())) {
            throw new RestApiException(AuthErrorCode.INVALID_PASSWORD);
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
        cookeUtils.deleteCookie(res, "rt");
        return new ResVo(1);
    }

    public UserSignVo getRefreshToken(HttpServletRequest req) {
        Cookie cookie = cookeUtils.getCookie(req, "rt");
        if (cookie == null) {
            return UserSignVo.builder().
                    result(FAIL)
                    .accessToken(null)
                    .build();
        }
        String token = cookie.getValue();
        if (!jwtTokenProvider.isValidateToken(token)) {
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


        if (dto.getNickname() == null ||
                dto.getAddress() == null ||
                dto.getTel() == null) {
            throw new RestApiException(CommonErrorCode.INVALID_PARAMETER);
        }
        if (!Pattern.matches(REGEXP_USER_TEL,dto.getTel())) {
            throw new RestApiException(UserErrorCode.REGEXP_TEL);
        }
        if (Pattern.matches(REGEXP_PATTERN_SPACE_CHAR,dto.getNickname())) {
            throw new RestApiException(UserErrorCode.NOT_NICK_NAME);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        if (dto.getFile() != null) {
            String path = "/user/" + dto.getIuser();
            String savedPicFileNm = myFileUtils.transferTo(dto.getFile(), path);
            dto.setPic(savedPicFileNm);
        }
        mapper.updateUser(dto);
        return new ResVo(SUCCESS);
    }

    public UserInfoVo selUserInfo() {
        return mapper.selUserInfo(authenticationFacade.getLoginUserPk());
    }

    public List<ReservationVo> getReservation(UserMyPageDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        return mapper.selReservation(dto);
    }

    public List<ReviewVo> getUserReview(UserMyPageDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<ReviewVo> reviews = mapper.selUserReview(dto);
        List<ReviewPk> reviewPkList = new ArrayList<>();
        Map<ReviewPk, ReviewVo> reviewMap = new HashMap<>();
        for (ReviewVo vo : reviews) {
            ReviewPk pk = new ReviewPk(vo.getCheckShop(), vo.getIreview());
            reviewMap.put(pk, vo);
            reviewPkList.add(pk);
        }
        for (ReviewPk pk : reviewPkList) {
            List<String> pics = mapper.selUserReviewPic(pk);
            reviewMap.get(pk).setPics(pics);
        }
        return reviews;
    }

    public List<BookmarkShopVo> getUserBookmark(UserMyPageDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        List<BookmarkShopVo> list= mapper.selUserBookmark(dto);
        List<Integer> ishopList= new ArrayList<>();
        Map<Integer, BookmarkShopVo> shopMap= new HashMap<>();
        for(BookmarkShopVo vo: list) {
            if(vo.getImeat()!=0){
                ishopList.add(vo.getIshop());
                shopMap.put(vo.getIshop(),vo);
            }
        }
        List<ShopFacilityVo> facilityList= shopMapper.selShopFacility(ishopList);
        for(ShopFacilityVo vo: facilityList) {
            if(shopMap.get(vo.getIshop()).getImeat()!=0) {
                shopMap.get(vo.getIshop()).getFacilities().add(vo.getFacility());
            }
        }
        return list;
    }

    public ResVo delShopReview(ReviewDelDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.delShopReviewPics(dto);
        return new ResVo(mapper.delShopReview(dto));
    }
}
