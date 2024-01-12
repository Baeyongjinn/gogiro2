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
        if(dto.getIboard() == 0) {
            return new ResVo(0);
        }
        return new ResVo(1);
    }

    public ResVo updCommunity(CommunityUpdDto dto) {
        CommunityEntity entity = mapper.entityCommunity(dto.getIuser(), dto.getIboard());
        if(entity == null) {
            return new ResVo(0);
        }
        mapper.updCommunity(dto);
        mapper.delByCommunityPics(dto);
        mapper.insCommunityPics(dto);
        return new ResVo(1);
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
        CommunityEntity entity = mapper.entityCommunity(dto.getIuser(), dto.getIboard());
        if(entity == null) {
            return new ResVo(0);
        }
        mapper.delPicCommunity(dto.getIboard());
        mapper.delCommunity(dto);
        return new ResVo(1);
    }
}
