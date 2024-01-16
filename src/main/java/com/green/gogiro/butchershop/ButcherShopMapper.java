package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ButcherShopMapper {

    List<ButcherSelVo> selButcherShopAll(ButcherSelDto dto);

    List<ButcherPicsVo> selButcherShopPicList(List<Integer> pk);

    List<String> selButcherShopPics(int ibutcher);

    int insButcherReview(ButcherReviewDto dto);

    int insButcherReviewPic(ButcherReviewDto dto);

    ButcherShopDetailVo selButcherShopDetail(int ibutcher);

    List<DetailMenu> selMenuDetail(int ibutcher);

    List<ReviewDetail> selReviewDetail(int ibutcher);

    List<ReviewPicVo> selReviewPicDetail(int ibutcher);

    ButcherEntity selButcherEntity(int ibutcher);

    List<String> selButcherPicsForTest(int ibutcher);

    Integer selButcherReviewForTest(int ireview);

    Integer selButcherBookmark(ButcherBookmarkDto dto);

    void butcherBookmarkOn(ButcherBookmarkDto dto);
    void butcherBookmarkOff(ButcherBookmarkDto dto);
}
