package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.ResVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ButcherShopService {
    private final ButcherShopMapper mapper;

    public List<ButcherSelVo> getButList(ButcherSelDto dto) {

        List<ButcherSelVo> list = mapper.selButcherShopAll(dto);
        List<Integer> pk = new ArrayList<>();
        Map<Integer, ButcherSelVo> butMap = new HashMap<>();
        for (ButcherSelVo vo : list) {
            pk.add(vo.getIbutcher());
            butMap.put(vo.getIbutcher(), vo);
        }
        if (pk.size() > 0) {
            List<ButcherPicsVo> pics = mapper.selButcherShopPics(pk);

            for (ButcherPicsVo vo2 : pics) {
                ButcherSelVo butcherSelVo = butMap.get(vo2.getIbutcher());
                List<String> strPicsList = butcherSelVo.getPics();
                strPicsList.add(vo2.getPic());
            }
        }
        return list;
    }

    public ResVo postButReview(ButcherReviewDto dto) {
        mapper.insButcherReview(dto);
        mapper.insButcherReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

    public List<ButcherShopDetailVo> getShopDetail(int ibutcher){
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
