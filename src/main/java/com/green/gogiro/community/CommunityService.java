package com.green.gogiro.community;

import static com.green.gogiro.common.Const.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.*;
import com.green.gogiro.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CommunityService {
    private final CommunityMapper mapper;

    private final AuthenticationFacade authenticationFacade;

    public ResVo insCommunity(CommunityInsDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insCommunity(dto);
        if(dto.getPics().size() >= 5){
            return new ResVo(FAIL);
        }
        mapper.insCommunityPics(dto);
        if(dto.getIboard() == 0) {
            return new ResVo(FAIL);
        }
        return new ResVo(SUCCESS);
    }

    public ResVo updCommunity(CommunityUpdDto dto) {
        Integer check = mapper.checkCommunity(dto.getIboard());
        if(check == null){
            return new ResVo(FAIL);
        }
        CommunityEntity entity = mapper.entityCommunity(dto.getIuser(), dto.getIboard());
        if(entity == null) {
            return new ResVo(FAIL);
        }
        mapper.updCommunity(dto);
        mapper.delByCommunityPics(dto);
        mapper.insCommunityPics(dto);
        return new ResVo(SUCCESS);
    }

    public List<CommunitySelVo> selCommunity(CommunitySelDto dto) {
        List<CommunitySelVo> list = mapper.selCommunity(dto);
        List<Integer> iboard = new ArrayList<>();
        Map<Integer,CommunitySelVo> boardMap = new HashMap<>();
        int count = mapper.selCommunityCount();
        for(CommunitySelVo vo : list) {
            iboard.add(vo.getIboard());
            boardMap.put(vo.getIboard(),vo);
        }
        List<CommunityPicsVo> pics = mapper.selPicCommunity(iboard);
        for(CommunityPicsVo pic : pics){
            boardMap.get(pic.getIboard()).getPics().add(pic.getPic());
        }
        for(int i = 0; i < list.size(); i++) {
            list.get(i).setBoardNum(count - dto.getStartIdx() - i);
        }
        return list;
    }

    public ResVo delCommunity(CommunityDelDto dto) {
        Integer check = mapper.checkCommunity(dto.getIboard());
        if(check == null) {
            return new ResVo(FAIL);
        }
        CommunityEntity entity = mapper.entityCommunity(dto.getIuser(), dto.getIboard());
        if(entity == null) {
            return new ResVo(FAIL);
        }
        mapper.delPicCommunity(dto.getIboard());
        mapper.delCommunity(dto);
        return new ResVo(SUCCESS);
    }

    public ResVo postCommunityComment(CommunityCommentInsDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        return new ResVo(mapper.insCommunityComment(dto));
    }

    public ResVo delCommunityComment(CommunityCommentDelDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        return new ResVo(mapper.delCommunityComment(dto));
    }
}
