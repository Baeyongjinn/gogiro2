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

    int delCommunityPic(List<Integer> icommuPics);

    int selCommunityCount();

    List<CommunitySelBeAfDto> beforeTitleNextTitle(int iboard);

    List<CommunityBySelPicsDto> selCommunityPics(List<Integer> icommuPics);

    List<CommunitySelVo> selCommunity(CommunitySelDto dto);

    List<CommunityBySelPicsDto> selByCommunityPics(int iboard);

    List<CommunityPicsVo> selPicCommunity(List<Integer> iboard);

    List<CommunityCommentVo> selCommunityComments(int iboard);

    CommunityDetailVo selDetailCommunity(int iboard);

    CommunityEntity entityCommunity(int iboard);

    int delCommunity(CommunityDelDto dto);

    int delCommunityPic(int iboard);

    int delCommunityAllComment(CommunityDelDto dto);

    Integer checkCommunity(int iboard);

    int insCommunityComment(CommunityCommentInsDto dto);

    int delCommunityComment(CommunityCommentDelDto dto);
}
