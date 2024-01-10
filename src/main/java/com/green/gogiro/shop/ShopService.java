package com.green.gogiro.shop;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.shop.model.ShopPicsVo;
import com.green.gogiro.shop.model.ShopReviewDto;
import com.green.gogiro.shop.model.ShopSelDto;
import com.green.gogiro.shop.model.ShopSelVo;
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
        if (pk.size() > 0) {
            List<ShopPicsVo> pics = mapper.selShopPics(pk);
            for (ShopPicsVo vo2 : pics) {
                ShopSelVo shopSelVo = map.get(vo2.getIshop());
                List<String> picList = shopSelVo.getPics();
                picList.add(vo2.getPic());
            }
        }
        return list;
    }

    public ResVo postShopReview(ShopReviewDto dto) {
        mapper.postShopReview(dto);
        mapper.postShopReviewPic(dto);
        return new ResVo(dto.getIreview());
    }

}
