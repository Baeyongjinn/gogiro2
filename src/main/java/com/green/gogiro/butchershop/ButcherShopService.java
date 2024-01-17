package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.Const;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.user.UserMapper;
import com.green.gogiro.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ButcherShopService {
    private final ButcherShopMapper mapper;
    private final UserMapper userMapper;

    private final AuthenticationFacade authenticationFacade;

    public List<ButcherSelVo> getButList(ButcherSelDto dto) {
        if(dto.getPage() <= 0){
            throw new RestApiException(AuthErrorCode.VALID_PAGE);
        }
        List<ButcherSelVo> list = mapper.selButcherShopAll(dto);
        List<Integer> pk = new ArrayList<>();
        Map<Integer, ButcherSelVo> butMap = new HashMap<>();
        for (ButcherSelVo vo : list) {
            pk.add(vo.getIbutcher());
            butMap.put(vo.getIbutcher(), vo);
        }
        List<ButcherPicsVo> pics = mapper.selButcherShopPicList(pk);
        for (ButcherPicsVo pic : pics) {
            butMap.get(pic.getIbutcher()).getPics().add(pic.getPic());
        }

        return list;
    }

    public ResVo postButReview(ButcherReviewDto dto) {
        ButcherEntity entity = mapper.selButcherEntity(dto.getIbutcher());

        //없는 가게일 경우
        if (entity == null) {
            throw new RestApiException(AuthErrorCode.VALID_SHOP);
        }
        //입력한 가게와 동일한 가게인지 확인
        if (entity.getIbutcher() != dto.getIbutcher()) {
            return new ResVo(3);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        if(dto.getReview() == null || Pattern.matches(Const.REGEXP_PATTERN_SPACE_CHAR,dto.getReview())){
            throw new RestApiException(AuthErrorCode.NOT_COMMUNITY_CONTEND);
        }
        mapper.insButcherReview(dto);
        mapper.insButcherReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

    public ButcherShopDetailVo getShopDetail(int ibutcher) {
        ButcherEntity entity = mapper.selButcherEntity(ibutcher);
        //없는 가게일 경우 빈 리스트 보내기
        if (entity == null) {
            return new ButcherShopDetailVo();
        }
        int i;
        try {
            i= authenticationFacade.getLoginUserPk();
        } catch(Exception e) {
            i= 0;
        }
        ButDto dto= new ButDto(i, ibutcher);

        ButcherShopDetailVo vo = mapper.selButcherShopDetail(dto);
        List<DetailMenu> menus = mapper.selMenuDetail(ibutcher);
        vo.setMenus(menus);
        List<String> shopPics = mapper.selButcherShopPics(ibutcher);
        vo.setPics(shopPics);
        List<ReviewDetail> reviews = mapper.selReviewDetail(ibutcher);
        List<Integer> ireview= new ArrayList<>();
        Map<Integer, ReviewDetail> map= new HashMap<>();
        for(ReviewDetail review: reviews) {
            ireview.add(review.getIreview());
            map.put(review.getIreview(), review);
        }
        List<ReviewPicVo> pics = mapper.selReviewPicDetail(ibutcher);
        for (ReviewPicVo pic : pics) {
            map.get(pic.getIreview()).getPics().add(pic.getPic());
        }
        vo.setReviews(reviews);
        return vo;
    }

    public ResVo toggleButcherBookmark(ButcherBookmarkDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        dto.setOn(mapper.selButcherBookmark(dto) == null);
        if(dto.isOn()) {
            mapper.butcherBookmarkOn(dto);
            return new ResVo(1);
        } else {
            mapper.butcherBookmarkOff(dto);
            return new ResVo(0);
        }
    }
}
