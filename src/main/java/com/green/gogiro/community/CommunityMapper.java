package com.green.gogiro.community;

import com.green.gogiro.community.model.CommunityDelDto;
import com.green.gogiro.community.model.CommunityInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    int insCommunity(CommunityInsDto dto);

    int insCommunityPics(CommunityInsDto dto);

    int delCommunity(CommunityDelDto dto);

    int delpicCommunity(int iboard);
}
