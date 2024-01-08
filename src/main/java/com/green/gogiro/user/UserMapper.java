package com.green.gogiro.user;

import com.green.gogiro.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int signupUser(UserSignupDto dto);

    String signinUser(String email);

    int updateUser(UserUpdDto dto);

    UserInfoVo selUserInfo(int iuser);

    UserEntity userEntity(int iuser);

    String checkNickname(String nickname);
}
