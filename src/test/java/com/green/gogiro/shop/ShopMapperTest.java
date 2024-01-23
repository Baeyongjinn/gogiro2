package com.green.gogiro.shop;

import com.green.gogiro.shop.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ShopMapperTest {

    @Autowired
    private ShopMapper mapper;

    @Test
    void selShopAll() {


    }


    @Test
    void selShopDetail() {

    }


    @Test
    void insShopReview() throws Exception {
        ShopReviewDto dto = new ShopReviewDto();
        dto.setIuser(4);
        dto.setIshop(1);
        dto.setStar(1);
        dto.setReview("리뷰입니당");

        int result = mapper.insShopReview(dto);
        assertEquals(1,result);
    }


    @Test
    void selShopBookmark() throws Exception {
        ShopBookmarkDto dto = new ShopBookmarkDto();
        dto.setIuser(4);
        dto.setIshop(20);

        int result = mapper.shopBookmarkOn(dto);
        assertEquals(1,result);
    }


}