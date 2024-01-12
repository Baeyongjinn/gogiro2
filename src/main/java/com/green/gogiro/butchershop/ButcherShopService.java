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
           List<ButcherPicsVo> pics = mapper.selButcherShopPics(pk);
        for(ButcherPicsVo pic : pics){
            ButcherSelVo vo2 = butMap.get(pic.getIbutcher());
            List<String> voPics= vo2.getPics();
            voPics.add(pic.getPic());
        }

        return list;
    }

    public ResVo postButReview(ButcherReviewDto dto) {
        ButcherEntity entity = mapper.selButcherEntity(dto.getIbutcher());
        UserEntity userEntity = userMapper.userEntity(dto.getIuser());
        //없는 유저일 경우
        if(userEntity == null){
            return new ResVo(0);
        }
        //없는 가게일 경우
        if(entity == null){
            return new ResVo(2);
        }
        //입력한 가게와 동일한 가게인지 확인
        if(entity.getIbutcher() != dto.getIbutcher()) {
            return new ResVo(3);
        }
        mapper.insButcherReview(dto);
        mapper.insButcherReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

    public List<ButcherShopDetailVo> getShopDetail(int ibutcher){
        ButcherEntity entity = mapper.selButcherEntity(ibutcher);
        //없는 가게일 경우 빈 리스트 보내기
        if(entity == null){
            List<ButcherShopDetailVo> bt = new ArrayList<>();
            return bt;
        }
        List<ButcherShopDetailVo> list = mapper.selButcherShopDetail(ibutcher);
        List<Integer> pk= new ArrayList<>();
        Map<Integer,ButcherShopDetailVo> butMap = new HashMap<>();
        for(ButcherShopDetailVo vo : list){
            pk.add(vo.getIbutcher());
            butMap.put(vo.getIbutcher(),vo);
            List<DetailMenu> menus= mapper.selMenuDetail(vo.getIbutcher());
            vo.setMenus(menus);
            List<ReviewDetail> reviews= mapper.selReviewDetail(vo.getIbutcher());
            for(ReviewDetail review: reviews){
                List<ReviewPicVo> reviewPics= mapper.selReviewPicDetail(review.getIreview());
                for(ReviewPicVo picVo: reviewPics){
                    review.getPic().add(picVo.getPic());
                }
            }
            vo.setReviews(reviews);
        }
        List<ButcherPicsVo> butcherPics= mapper.selButcherShopPics(pk);
        for(ButcherPicsVo vo: butcherPics){
            butMap.get(vo.getIbutcher()).getPics().add(vo.getPic());
        }
        return list;
    }
}
