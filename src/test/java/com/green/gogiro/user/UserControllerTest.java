package com.green.gogiro.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.user.model.UserSignupDto;
import org.junit.jupiter.api.Test;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockMvcConfig
@WebMvcTest(UserController.class)//빈 등록된 컨트롤러를 객체화시킴
class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private UserService service;
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Test
    @WithMockUser
    public void signupTest() throws Exception{
        final int expected= 12;
        UserSignupDto dto= new UserSignupDto();
        dto.setEmail("zxcasd@naver.com");
        dto.setUpw("1234");
        dto.setCheckUpw("1234");
        dto.setName("테스트");
        dto.setNickname("테스트");
        dto.setBirth("20110222");
        dto.setGender("남");
        dto.setAddress("대구어딘가");
        dto.setTel("01012345678");
        MockMultipartFile file = new MockMultipartFile("pic", "tooth.png", "multipart/form-data", "uploadFile".getBytes(StandardCharsets.UTF_8));
        MockMultipartFile request = new MockMultipartFile("dto", null, "application/json", mapper.writeValueAsString(dto).getBytes(StandardCharsets.UTF_8));
        given(service.signup(any())).willReturn(new ResVo(expected));
        MvcResult mr= mvc.perform(
                        MockMvcRequestBuilders
                                .multipart(HttpMethod.POST,"/api/user/signup")
                                .file(file)
                                .file(request)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                                .with(csrf())
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        verify(service).signup(any());
        String content= mr.getResponse().getContentAsString();
        ResVo result= mapper.readValue(content,ResVo.class);
        assertEquals(expected, result.getResult());
    }

}