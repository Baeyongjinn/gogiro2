package com.green.gogiro.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.shop.model.ShopReviewDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockMvcConfig
@WebMvcTest(ShopController.class)
public class ShopControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShopService service;

    @Autowired
    private ObjectMapper mapper;


    @Test
    void postShopReview() throws Exception {
        ResVo result = new ResVo(1);

        given(service.postShopReview(any())).willReturn(result);

        ShopReviewDto dto = new ShopReviewDto();
        dto.setIuser(4);
        dto.setIshop(1);
        dto.setStar(10);
        dto.setReview("마이따");
        List<String > pics = new ArrayList<>();
        pics.add("aa.jpg");
        pics.add("bb.jpg");
        dto.setPics(pics);

        mvc.perform(MockMvcRequestBuilders
                .post("/api/shop")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto))
        )
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());
        verify(service).postShopReview(any());
    }




}
