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

    List<ShopDetailMenu> selMenuDetail(int ishop);

    List<ShopReviewDetail> selReviewDetail(int ishop);

    List<ShopReviewPicVo> selReviewPicDetail(int ishop);

    List<String> shopFacilities(int ishop);

    int postShopReview(ShopReviewDto dto);

    int postShopReviewPic(ShopReviewDto dto);
    Integer selShopBookmark(ShopBookmarkDto dto);
    void ShopBookmarkOn(ShopBookmarkDto dto);
    void ShopBookmarkOff(ShopBookmarkDto dto);

    ShopEntity selShopEntity(int ishop);
}
