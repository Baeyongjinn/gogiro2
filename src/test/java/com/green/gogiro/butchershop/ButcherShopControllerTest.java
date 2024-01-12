package com.green.gogiro.butchershop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.butchershop.model.ButcherSelVo;
import com.green.gogiro.shop.ShopService;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MockMvcConfig
@WebMvcTest(ButcherShopControllerTest.class)
class ButcherShopControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShopService service;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void getButList() throws Exception{
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("page","1");

        ButcherSelVo vo = new ButcherSelVo();
        vo.setIbutcher(3);
       // vo.
       // List<ButcherSelVo> list = new ArrayList<>();

    }

    @Test
    void postButReview() throws Exception{

    }

    @Test
    void getShopDetail() {
    }
}