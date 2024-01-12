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
        mapper.delByCommunityPics(dto);
        mapper.insCommunityPics(dto);
        return new ResVo(dto.getIboard());
    }

    public List<CommunitySelVo> selCommunity(CommunitySelDto dto) {
        List<CommunitySelVo> list = mapper.selCommunity(dto);
        int count = mapper.selCommunityCount();
        for(CommunitySelVo vo : list) {
            List<String> pics = mapper.selPicCommunity(vo.getIboard());
            vo.setPics(pics);
        }
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setBoardNum(count - dto.getStartIdx() - i);
        }
        return list;
    }

    public ResVo delCommunity(CommunityDelDto dto) {
        mapper.delPicCommunity(dto.getIboard());
        int result = mapper.delCommunity(dto);
        return new ResVo(result);
    }
}
