package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ButcherShopMapperTest {
    @Autowired
    private ButcherShopMapper mapper;

    @Test
    void selButcherShopAllTest() throws Exception{
        ButcherSelDto dto= new ButcherSelDto();
        dto.setPage(1);

        List<ButcherSelVo> result= mapper.selButcherShopAll(dto);

        assertEquals(2, result.size());
    }

    @Test
    void selButcherShopPicListTest() throws Exception {
        List<Integer> butcherShop= new ArrayList<>();
        butcherShop.add(1);
        butcherShop.add(2);
        List<ButcherPicsVo> pics= mapper.selButcherShopPicList(butcherShop);
        int count= 0;
        for(Integer ibutcher: butcherShop) {
            List<String> picList= mapper.selButcherPicsForTest(ibutcher);
            count+= picList.size();
        }
        assertEquals(count,pics.size());
    }

    @Test
    void insButcherReviewTest() throws Exception {

    }

    @Test
    void insButcherReviewPicTest() throws Exception {
        ButcherReviewDto dto= new ButcherReviewDto();
        dto.setIreview(2);
        List<String> pics= new ArrayList<>();
        pics.add("testPic");
        pics.add("testPic2");
        dto.setPics(pics);
        int insertPics= mapper.insButcherReviewPic(dto);
        assertEquals(pics.size(), insertPics);
    }

//    @Test
//    void selButcherShopDetailTest() throws Exception {
//        ButcherShopDetailVo vo1= mapper.selButcherShopDetail(1);
//        ButcherShopDetailVo vo2= mapper.selButcherShopDetail(2);
//        assertEquals("다정축산물직판장",vo1.getName());
//        assertEquals("남문한우백화점 부림축산",vo2.getName());
//        ButcherShopDetailVo vo3= mapper.selButcherShopDetail(3);
//        assertEquals(0,vo3.getIbutcher());
//
//    }

    @Test
    void selMenuDetailTest() throws Exception {
    }

    @Test
    void selReviewDetailTest() throws Exception {
    }

    @Test
    void selReviewPicDetailTest() throws Exception {
    }

    @Test
    void selButcherEntityTest() throws Exception {
    }
}