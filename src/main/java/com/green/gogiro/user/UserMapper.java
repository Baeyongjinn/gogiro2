package com.green.gogiro.user;

import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int signupUser(UserSignupDto dto);

    String signinUser(String email);

    int updateUser(UserUpdDto dto);

    UserInfoVo selUserInfo(int iuser);

    UserEntity userEntity(int iuser);

    String checkNickname(String nickname);

    List<ReservationVo> selReservation(int iuser);

    List<ReviewVo> selUserReview(int iuser);

    List<String> selUserReviewPic(ReviewPk pk);

    List<BookmarkShopVo> selUserBookmark(int iuser);
}
