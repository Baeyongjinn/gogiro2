package com.green.gogiro.community;

import com.green.gogiro.community.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    int insCommunity(CommunityInsDto dto);

    // 커뮤 사진 등록
    int insCommunityPics(CommunityInsDto dto);
    //커뮤 사진 수정
    int insCommunityPics(CommunityUpdDto dto);

    int updCommunity(CommunityUpdDto dto);

    int delByCommunityPics(CommunityUpdDto dto);

    int selCommunityCount();

    List<CommunitySelVo> selCommunity(CommunitySelDto dto);

    List<String> selPicCommunity(int iboard);

    CommunityEntity entityCommunity(int iuser, int iboard);

    int delCommunity(CommunityDelDto dto);

    int delPicCommunity(int iboard);
}
