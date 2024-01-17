package com.green.gogiro.shop;

import com.green.gogiro.common.Const;
import com.green.gogiro.common.MyFileUtils;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.shop.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.green.gogiro.exception.AuthErrorCode.*;


@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopMapper mapper;

    private final AuthenticationFacade authenticationFacade;
    private final MyFileUtils myFileUtils;

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

    public ShopReviewPicsInsDto postShopReview(ShopReviewDto dto) {
        ShopEntity entity = mapper.selShopEntity(dto.getIshop());
        dto.setIuser(authenticationFacade.getLoginUserPk());

        if(entity == null) {
            throw new RestApiException(VALID_SHOP);
        }
        if (entity.getIshop() != dto.getIshop()) {
            throw new RestApiException(CHECK_SHOP);
        }

        mapper.insShopReview(dto);

        if (Pattern.matches(Const.REGEXP_PATTERN_SPACE_CHAR, dto.getReview())){
            throw new RestApiException(NOT_CONTENT);
        }

        String target = "/shop/"+dto.getIshop()+"/review/" + dto.getIreview() + "/";
        ShopReviewPicsInsDto pDto = new ShopReviewPicsInsDto();

        pDto.setIreview(dto.getIreview());

        for (MultipartFile file : dto.getPics()) {
            String saveFileNm = myFileUtils.transferTo(file,target);
            pDto.getPics().add(saveFileNm);
        }

        mapper.insShopReviewPic(pDto);

        if (dto.getPics().size() > Const.PIC_MAX) {
            throw new RestApiException(SIZE_PHOTO);
        }
        return pDto;
    }

    public ResVo toggleShopBookmark(ShopBookmarkDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        dto.setOn(mapper.selShopBookmark(dto) == null);
        if(dto.isOn()) {
            mapper.shopBookmarkOn(dto);
            return new ResVo(Const.ON);
        } else {
            mapper.shopBookmarkOff(dto);
            return new ResVo(Const.OFF);
        }
    }
}
