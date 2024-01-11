package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommunityService {
    private final CommunityMapper mapper;

    public ResVo insCommunity(CommunityInsDto dto) {
        mapper.insCommunity(dto);
        mapper.insCommunityPics(dto);
        return new ResVo(dto.getIboard());
    }

    public ResVo updCommunity(CommunityUpdDto dto) {
        mapper.updCommunity(dto);
        CommunityPicUpdDto dto2 = new CommunityPicUpdDto();
        List<String> pics = dto.getPics();
        dto2.setIboard(dto.getIboard());
        for(String pic : pics){
            dto2.setPic(pic);
            mapper.updPicCommunity(dto2);
        }
        return new ResVo(dto.getIboard());
    }

    public List<CommunitySelVo> selpicCommunity(CommunitySelDto dto) {
        List<CommunitySelVo> list = mapper.selCommunity(dto);
        for(CommunitySelVo vo : list) {
            List<String> pics = mapper.selpicCommunity(vo.getIboard());
            vo.setPics(pics);
        }
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setBoardNum(i + 1);
        }
        return list;
    }

    public ResVo delCommunity(CommunityDelDto dto) {
        mapper.delPicCommunity(dto.getIboard());
        int result = mapper.delCommunity(dto);
        return new ResVo(result);
    }
}
