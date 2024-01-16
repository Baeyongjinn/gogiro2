package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.UserMapper;
import com.green.gogiro.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ButcherShopService {
    private final ButcherShopMapper mapper;
    private final UserMapper userMapper;

    public List<ButcherSelVo> getButList(ButcherSelDto dto) {

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

        //없는 유저일 경우
//        if (userEntity == null) {
//            return new ResVo(0);
//        }
        //없는 가게일 경우
        if (entity == null) {
            return new ResVo(2);
        }
        //입력한 가게와 동일한 가게인지 확인
        if (entity.getIbutcher() != dto.getIbutcher()) {
            return new ResVo(3);
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
        ButcherShopDetailVo vo = mapper.selButcherShopDetail(ibutcher);
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
}
