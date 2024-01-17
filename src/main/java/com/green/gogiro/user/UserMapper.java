package com.green.gogiro.user;

import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int signupUser(UserSignupDto dto);

    int updUserPic(UserSignupDto dto);

    String signinUser(String email);

    int updateUser(UserUpdDto dto);

    UserInfoVo selUserInfo(int iuser);

    UserEntity userEntity(String email);

    String checkNickname(String nickname);

    List<ReservationVo> selReservation(UserMyPageDto dto);

    List<ReviewVo> selUserReview(UserMyPageDto dto);

    List<String> selUserReviewPic(ReviewPk pk);

    List<BookmarkShopVo> selUserBookmark(UserMyPageDto dto);

    int delShopReviewPics(int ireview);

    int delShopReview(ReviewDelDto dto);
}
