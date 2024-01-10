package com.green.gogiro.shop;


import com.green.gogiro.shop.model.ShopPicsVo;
import com.green.gogiro.shop.model.ShopReviewDto;
import com.green.gogiro.shop.model.ShopSelDto;
import com.green.gogiro.shop.model.ShopSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    List<ShopSelVo> selShopAll(ShopSelDto dto);

    List<ShopPicsVo> selShopPics(List<Integer> pk);

    int postShopReview(ShopReviewDto dto);

    int postShopReviewPic(ShopReviewDto dto);

}
