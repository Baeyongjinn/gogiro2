package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.CommunityDelDto;
import com.green.gogiro.community.model.CommunityInsDto;
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

    public ResVo delCommunity(CommunityDelDto dto) {
        mapper.delpicCommunity(dto.getIboard());
        int result = mapper.delCommunity(dto);
        return new ResVo(result);
    }
}
