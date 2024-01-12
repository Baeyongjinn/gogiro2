package com.green.gogiro.shop;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.shop.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopMapper mapper;

    public List<ShopSelVo> getShopList(ShopSelDto dto) {

        List<ShopSelVo> list = mapper.selShopAll(dto);
        List<Integer> pk = new ArrayList<>();
        Map<Integer, ShopSelVo> map = new HashMap<>();
        for (ShopSelVo vo : list) {
            pk.add(vo.getIshop());
            map.put(vo.getIshop(), vo);
        }

        mapper.selShopPics(pk);

        return list;
    }

    public List<ShopDetailVo> getShopDetail(int ishop) {
        List<ShopDetailVo> list = mapper.selShopDetail(ishop);
        List<Integer> pk = new ArrayList<>();
        Map<Integer, ShopDetailVo> Map = new HashMap<>();
        for (ShopDetailVo vo : list) {
            pk.add(vo.getIshop());
            Map.put(vo.getIshop(), vo);
            List<ShopDetailMenu> menus = mapper.selMenuDetail(vo.getIshop());
            vo.setMenus(menus);
            List<ShopReviewDetail> reviews = mapper.selReviewDetail(vo.getIshop());
            for (ShopReviewDetail review : reviews) {
                List<ShopReviewPicVo> reviewPics = mapper.selReviewPicDetail(review.getIreview());
                for (ShopReviewPicVo picVo : reviewPics) {
                    review.getPic().add(picVo.getPic());
                }
            }
            vo.setReviews(reviews);
        }
        List<ShopPicsVo> Pics = mapper.selShopPics(pk);

        for (ShopPicsVo vo : Pics) {
            Map.get(vo.getIshop()).getPics().add(vo.getPic());
        }
        return list;
    }

    public ResVo postShopReview(ShopReviewDto dto) {
        mapper.postShopReview(dto);
        mapper.postShopReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

}
