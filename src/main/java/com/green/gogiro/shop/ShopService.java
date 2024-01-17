package com.green.gogiro.shop;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.shop.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.green.gogiro.exception.AuthErrorCode.*;

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
        // **************리터럴 처리
        ShopEntity entity = mapper.selShopEntity(dto.getIshop());

        if(entity == null) {
            throw new RestApiException(VALID_SHOP);
        }
        if (entity.getIshop() != dto.getIshop()) {
            throw new RestApiException(CHECK_SHOP);
        }

        dto.setIuser(authenticationFacade.getLoginUserPk());

        int reviewCheck = mapper.postShopReview(dto);
        int reviewPicCheck = mapper.postShopReviewPic(dto);
        if (reviewCheck == 0) {
            return new ResVo(0);
            // 리뷰가 작성이 되지 않았을 때
        }
        if (dto.getReview() == null){
            return new ResVo(0);
            // 리뷰를 꼭 작성해야함
        }
        if (reviewPicCheck == 0) {
            return new ResVo(0);
            // 리뷰 사진이 작성되지 않았을 때
        }
        if (dto.getPics() == null) {
            throw new RestApiException(MUST_PHOTO);
        }
        if (dto.getPics().size() > 5) {
            throw new RestApiException(SIZE_PHOTO);
        }
        return new ResVo(dto.getIreview());
    }

    public ResVo toggleShopBookmark(ShopBookmarkDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        dto.setOn(mapper.selShopBookmark(dto) == null);
        if(dto.isOn()) {
            mapper.ShopBookmarkOn(dto);
            return new ResVo(1);
        } else {
            mapper.ShopBookmarkOff(dto);
            return new ResVo(0);
        }
    }
}
