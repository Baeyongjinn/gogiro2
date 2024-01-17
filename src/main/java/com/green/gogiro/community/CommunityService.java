package com.green.gogiro.community;

import static com.green.gogiro.common.Const.*;


import com.green.gogiro.common.MyFileUtils;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.*;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CommunityService {
    private final CommunityMapper mapper;
    private final MyFileUtils myFileUtils;
    private final AuthenticationFacade authenticationFacade;

    public ResVo insCommunity(CommunityInsDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insCommunity(dto);
        //제목을 입력하지 않는 경우
        if(dto.getTitle() == null) {
            throw new RestApiException(AuthErrorCode.NOT_COMMUNITY_TITLE);
        }
        //내용을 입력하지 않는 경우
        if(dto.getContents() == null) {
            throw new RestApiException(AuthErrorCode.NOT_COMMUNITY_CONTEND);
        }
        //사진을 5장 초과했을 경우
        if(dto.getPics().size() >= 5){
            throw new RestApiException(AuthErrorCode.SIZE_PHOTO);
        }
        //사진을 넣지 않는경우
        if(dto.getPics() == null) {
            throw new RestApiException(AuthErrorCode.MUST_PHOTO);
        }
        String target = "/community/" + dto.getIboard();
        for(MultipartFile file : dto.getFiles()) {
            String saveFileNm = myFileUtils.transferTo(file, target);
            dto.getPics().add(saveFileNm);
        }
        mapper.insCommunityPics(dto);
        if(dto.getIboard() == 0) {
            throw new RestApiException(AuthErrorCode.NOT_COMMUNITY);
        }
        return new ResVo(SUCCESS);
    }

    public ResVo updCommunity(CommunityUpdDto dto) {
        Integer check = mapper.checkCommunity(dto.getIboard());
        if(check == null){
            return new ResVo(FAIL);
        }
        CommunityEntity entity = mapper.entityCommunity(authenticationFacade.getLoginUserPk(), dto.getIboard());
        if(entity == null) {
            return new ResVo(FAIL);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
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
        CommunityEntity entity = mapper.entityCommunity(authenticationFacade.getLoginUserPk(), dto.getIboard());
        if(entity == null) {
            return new ResVo(FAIL);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
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
