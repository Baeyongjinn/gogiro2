package com.green.gogiro.user;

import com.green.gogiro.common.*;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.user.model.UserSigninDto;
import com.green.gogiro.user.model.UserSignupDto;
import com.green.gogiro.user.model.UserUpdDto;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)//스프링 컨테이너 올리기
@Import({UserService.class})//얘는 빈 등록을 좀 해 줘
class UserServiceTest {
    @Autowired
    private UserService service;
    @MockBean
    private UserMapper mapper;
    @MockBean
    private ShopMapper shopMapper;
    @MockBean
    private PasswordEncoder passwordEncoder;
    @MockBean
    private JwtTokenProvider jwtTokenProvider;
    @MockBean
    private AppProperties appProperties;
    @MockBean
    private CookieUtils cookeUtils;
    @MockBean
    private AuthenticationFacade authenticationFacade;
    @MockBean
    private MyFileUtils myFileUtils;

    @Test
    void signupTest() {
        UserSignupDto dto= new UserSignupDto();
        try {
            ResVo vo = service.signup(dto);
            assertEquals(0, vo.getResult());
        } catch (NullPointerException e) {
        } finally {
            verify(mapper).checkNickname(any());
        }
    }

    @Test
    void checkNickNameTest() {
        try {
            ResVo vo = service.checkNickName("zzz");
            assertEquals(1, vo.getResult());
        } catch (NullPointerException e) {
        } finally {
            verify(mapper).checkNickname(any());
        }
    }

    @Test
    void updateUserTest() {
        UserUpdDto dto= new UserUpdDto();
        service.updateUser(dto);
        verify(authenticationFacade).getLoginUserPk();
    }
}