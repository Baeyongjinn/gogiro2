package com.green.gogiro.butchershop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.butchershop.model.ButcherSelDto;
import com.green.gogiro.butchershop.model.ButcherSelVo;
import com.green.gogiro.shop.ShopService;
import lombok.SneakyThrows;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        vo.setLocation("dd");
        vo.setX("111.ddd.dd");
        vo.setY("333.333.444");

        List<String> pics = new ArrayList<>();
        pics.add("ddd");
        pics.add("fff");
        vo.setPics(pics);

        List<ButcherSelVo> list = new ArrayList<>();
        list.add(vo);



        mvc.perform(
                MockMvcRequestBuilders
                        .get("/api/butcher-shop")
                        .params(params)
        ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(list)))
                .andDo(print());

        verify(service).getShopList(any());

    }

    @Test
    void postButReview() throws Exception{

    }

    @Test
    void getShopDetail() {
    }
}