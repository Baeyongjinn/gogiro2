package com.green.gogiro.user;

import com.green.gogiro.common.AppProperties;
import com.green.gogiro.common.CookieUtils;
import com.green.gogiro.common.MyFileUtils;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.shop.ShopMapper;
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
    private MockMultipartFile file;

    @BeforeEach
    public void before() throws Exception {
        String fileNm = "cat.jpg";
        String filePath = "D:/home/download/gksk/"+ fileNm;
        FileInputStream fis = new FileInputStream(filePath);
        this.file = new MockMultipartFile("pic", fileNm, "jpg", fis);
    }

    @Test
    void signup() {
    }

    @Test
    void signin() {
    }

    @Test
    void signout() {
    }

    @Test
    void getRefreshToken() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void selUserInfo() {
    }

    @Test
    void getReservation() {
    }

    @Test
    void getUserReview() {
    }

    @Test
    void getUserBookmark() {
    }

    @Test
    void delShopReview() {
    }
}