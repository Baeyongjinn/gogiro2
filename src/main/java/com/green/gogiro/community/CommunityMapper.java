package com.green.gogiro.community;

import com.green.gogiro.community.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    int insCommunity(CommunityInsDto dto);

    int insCommunityPics(CommunityInsDto dto);

    int updCommunity(CommunityUpdDto dto);

    int updPicCommunity(CommunityPicUpdDto dto);

    int selCommunityCount();

    List<CommunitySelVo> selCommunity(CommunitySelDto dto);

    List<String> selpicCommunity(int iboard);

    int delCommunity(CommunityDelDto dto);

    int delPicCommunity(int iboard);
}
