package com.green.gogiro.shop;


import com.green.gogiro.shop.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<ShopSelVo> selShopAll(ShopSelDto dto);

    List<ShopPicsVo> selShopPics(List<Integer> pk);

    List<ShopDetailVo> selShopDetail(int ishop);

    List<ShopDetailMenu> selMenuDetail(int ishop);

    List<ShopReviewDetail> selReviewDetail(int ishop);

    List<ShopReviewPicVo> selReviewPicDetail(List<Integer> ireview);

    int postShopReview(ShopReviewDto dto);

    int postShopReviewPic(ShopReviewDto dto);


}
