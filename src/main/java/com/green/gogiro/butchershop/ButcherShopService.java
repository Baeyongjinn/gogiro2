package com.green.gogiro.butchershop;

import com.green.gogiro.butchershop.model.ButcherPicsVo;
import com.green.gogiro.butchershop.model.ButcherReviewDto;
import com.green.gogiro.butchershop.model.ButcherSelDto;
import com.green.gogiro.butchershop.model.ButcherSelVo;
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
}
