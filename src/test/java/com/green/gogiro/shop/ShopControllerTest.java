package com.green.gogiro.shop;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.security.JwtTokenProvider;
import com.green.gogiro.shop.model.ShopReviewDto;
import com.green.gogiro.shop.model.ShopReviewPicsInsDto;
import com.green.gogiro.shop.model.ShopSelVo;
import org.junit.jupiter.api.Test;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
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
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

//    @Test
//    void getShopList() throws Exception{
//        List<ShopSelVo> list = new ArrayList<>();
//        ShopSelVo vo1 = new ShopSelVo();
//        vo1.setIshop(444);
//        ShopSelVo vo2 = new ShopSelVo();
//        vo2.setIshop(1234);
//        list.add(vo1);
//        list.add(vo2);
//        given(service.getShopList(any())).willReturn(list);
//        MvcResult mr = mvc.perform(MockMvcRequestBuilders.get("/api/shop")
//                .with(csrf())
//                .param("page","1"))
//                .andExpect(status().isOk())
//                .andDo(print())
//                .andReturn();
//        verify(service).getShopList(any());
//        String content = mr.getResponse().getContentAsString();
//        List<ShopSelVo> result = mapper.readValue(content, new TypeReference<>() {});
//
//        for (int i=0; i<result.size(); i++) {
//            assertEquals(list.get(i).getIshop(),result.get(i).getIshop());
//        }


    @Test
    @WithMockUser
    void postShopReview() throws Exception{
        ShopReviewDto dto = new ShopReviewDto();
        dto.setIshop(1);
        dto.setReview("리뷰");
        dto.setStar(1);
        MockMultipartFile file1 = new MockMultipartFile("pics", "a.jpg", "multipart/form-data", "pics".getBytes(StandardCharsets.UTF_8));
        MockMultipartFile file2 = new MockMultipartFile("pics", "a.jpg", "multipart/form-data", "pics".getBytes(StandardCharsets.UTF_8));
        MockMultipartFile request = new MockMultipartFile("dto", null, "application/json", mapper.writeValueAsString(dto).getBytes(StandardCharsets.UTF_8));
        ShopReviewPicsInsDto dto1 = new ShopReviewPicsInsDto();
        dto1.setIreview(1);
        List<String> pics = new ArrayList<>();
        pics.add("pic.jpg");
        dto1.setPics(pics);
        given(service.postShopReview(any())).willReturn(dto1);
        MvcResult mr= mvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.POST,"/api/shop")
                                                        .file(file1).file(file2)
                                                        .file(request)
                                                        .accept(MediaType.APPLICATION_JSON)
                                                        .contentType(MediaType.MULTIPART_FORM_DATA)
                                                        .with(csrf()))
                         .andExpect(status().isOk())
                         .andDo(print())
                         .andReturn();
        verify(service).postShopReview(any());
        String content= mr.getResponse().getContentAsString();
        ShopReviewPicsInsDto result= mapper.readValue(content,ShopReviewPicsInsDto.class);
        assertEquals(dto1.getIreview(), result.getIreview());
        assertEquals(dto1.getPics().get(0), result.getPics().get(0));
    }

    @Test
    void toggleShopBookmark() throws Exception{

    }


}
