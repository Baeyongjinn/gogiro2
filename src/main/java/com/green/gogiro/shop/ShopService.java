package com.green.gogiro.shop;

import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.security.AuthenticationFacade;
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

    private final AuthenticationFacade authenticationFacade;

    public List<ShopSelVo> getShopList(ShopSelDto dto) {

        List<ShopSelVo> list = mapper.selShopAll(dto);
        List<Integer> pk = new ArrayList<>();
        Map<Integer, ShopSelVo> map = new HashMap<>();
        for (ShopSelVo vo : list) {
            pk.add(vo.getIshop());
            map.put(vo.getIshop(), vo);
        }

        List<ShopPicsVo> picList=mapper.selShopPicList(pk);
        for(ShopPicsVo vo: picList){
            map.get(vo.getIshop()).getPics().add(vo.getPic());
        }

        return list;
    }

    public ShopDetailVo getShopDetail(int ishop) {
        int i;
        try {
            i= authenticationFacade.getLoginUserPk();
        } catch(Exception e) {
            i= 0;
        }
        ShopDto dto= new ShopDto(i,ishop);
        ShopDetailVo list = mapper.selShopDetail(dto);
        List<String> fa = mapper.shopFacilities(ishop);
        List<ShopDetailMenu> menus = mapper.selMenuDetail(ishop);
        List<String> pics2 = mapper.selShopPics(ishop);
        list.setFacilities(fa);
        list.setMenus(menus);
        list.setPics(pics2);


        List<Integer> ireview = new ArrayList<>();
        Map<Integer, ShopReviewDetail> reviewDetailMap = new HashMap<>();


        List<ShopReviewDetail> reviews = mapper.selReviewDetail(ishop);
        for (ShopReviewDetail review : reviews) {

            ireview.add(review.getIreview());
            reviewDetailMap.put(review.getIreview(), review);
        }
        List<ShopReviewPicVo> picVos = mapper.selReviewPicDetail(ishop);
        for (ShopReviewPicVo pics : picVos) {
            reviewDetailMap.get(pics.getIreview()).getPic().add(pics.getPic());
        }
        list.setReviews(reviews);
        return list;
    }

    public ResVo postShopReview(ShopReviewDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.postShopReview(dto);
        mapper.postShopReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

    public ResVo toggleShopBookmark(ShopBookmarkDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        dto.setOn(mapper.selShopBookmark(dto)==null);
        dto.setIuser(authenticationFacade.getLoginUserPk());
        if(dto.isOn()) {
            mapper.ShopBookmarkOn(dto);
            return new ResVo(1);
        } else {
            mapper.ShopBookmarkOff(dto);
            return new ResVo(0);
        }
    }
}
