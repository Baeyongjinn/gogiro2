package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.ButcherPicsVo;
import com.green.gogiro.butchershop.model.ButcherReviewDto;
import com.green.gogiro.butchershop.model.ButcherSelDto;
import com.green.gogiro.butchershop.model.ButcherSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ButcherShopMapper {

    List<ButcherSelVo> selButcherShopAll(ButcherSelDto dto);

    List<ButcherPicsVo> selButcherShopPics(List<Integer> pk);

    int insButcherReview(ButcherReviewDto dto);

    int insButcherReviewPic(ButcherReviewDto dto);
}
