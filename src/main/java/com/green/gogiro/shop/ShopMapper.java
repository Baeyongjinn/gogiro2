package com.green.gogiro.shop;


import com.green.gogiro.shop.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<ShopSelVo> selShopAll(ShopSelDto dto);

    List<String> selShopPics(int ishop);

    List<ShopPicsVo> selShopPicList(List<Integer> pk);

    ShopDetailVo selShopDetail(ShopDto dto);

    List<ShopFacilityVo> selShopFacility(List<Integer> ishop);

    List<ShopDetailMenu> selMenuDetail(int ishop);

    List<ShopReviewDetail> selReviewDetail(int ishop);

    List<ShopReviewPicVo> selReviewPicDetail(int ishop);

    List<String> shopFacilities(int ishop);

    int insShopReview(ShopReviewDto dto);

    int insShopReviewPic(ShopReviewPicsInsDto dto);
    Integer selShopBookmark(ShopBookmarkDto dto);
    void shopBookmarkOn(ShopBookmarkDto dto);
    void shopBookmarkOff(ShopBookmarkDto dto);

    ShopEntity selShopEntity(int ishop);
    Integer selShopCategory(int imeat);
}
