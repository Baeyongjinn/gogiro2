package com.green.gogiro.shop;

import com.green.gogiro.butchershop.model.ButcherPicsVo;
import com.green.gogiro.butchershop.model.DetailMenu;
import com.green.gogiro.butchershop.model.ReviewDetail;
import com.green.gogiro.butchershop.model.ReviewPicVo;
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

        List<ShopPicsVo> picList=mapper.selShopPics(pk);
        for(ShopPicsVo vo: picList){
            map.get(vo.getIshop()).getPics().add(vo.getPic());
        }

        return list;
    }

    public List<ShopDetailVo> getShopDetail(int ishop) {
        List<ShopDetailVo> list = mapper.selShopDetail(ishop);
        List<Integer> pk = new ArrayList<>();
        List<Integer> ireview = new ArrayList<>();
        Map<Integer, ShopReviewDetail> reviewDetailMap = new HashMap<>();
        Map<Integer, ShopDetailVo> shopMap = new HashMap<>();
        for (ShopDetailVo vo : list) {
            pk.add(vo.getIshop());
            shopMap.put(vo.getIshop(), vo);
        }
        List<ShopDetailMenu> menus = mapper.selMenuDetail(ishop);
        for (ShopDetailMenu menu : menus) {
            shopMap.get(menu.getIshop()).getMenus().add(menu);
        }
        List<ShopReviewDetail> reviews = mapper.selReviewDetail(ishop);
        for (ShopReviewDetail review : reviews) {
            shopMap.get(review.getIshop()).getReviews().add(review);
            reviewDetailMap.put(review.getIreview(), review);
            ireview.add(review.getIreview());
        }
        List<ShopReviewPicVo> picVos = mapper.selReviewPicDetail(ireview);
        for (ShopReviewPicVo pics : picVos) {
            reviewDetailMap.get(pics.getIreview()).getPic().add(pics.getPic());
        }
        List<ShopPicsVo> butcherPics = mapper.selShopPics(pk);
        for (ShopPicsVo vo : butcherPics) {
            shopMap.get(vo.getIshop()).getPics().add(vo.getPic());
        }
        List<ShopPicsVo> Pics = mapper.selShopPics(pk);
        for (ShopPicsVo vo : Pics) {
            reviewDetailMap.get(vo.getIshop()).getPic().add(vo.getPic());
        }
        return list;
    }

    public ResVo postShopReview(ShopReviewDto dto) {
        mapper.postShopReview(dto);
        mapper.postShopReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

}
