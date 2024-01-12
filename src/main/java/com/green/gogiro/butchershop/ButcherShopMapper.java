package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ButcherShopMapper {

    List<ButcherSelVo> selButcherShopAll(ButcherSelDto dto);

    List<ButcherPicsVo> selButcherShopPics(List<Integer> pk);

    int insButcherReview(ButcherReviewDto dto);

    int insButcherReviewPic(ButcherReviewDto dto);

    List<ButcherShopDetailVo> selButcherShopDetail(int ibutcher);

    List<DetailMenu> selMenuDetail(int ibutcher);

    List<ReviewDetail> selReviewDetail(int ibutcher);

    List<ReviewPicVo> selReviewPicDetail(List<Integer> ireview);

    ButcherEntity selButcherEntity(int ibutcher);
}
