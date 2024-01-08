package com.green.gogiro.user;

import com.green.gogiro.user.model.UserSigninDto;
import com.green.gogiro.user.model.UserSignupDto;
import com.green.gogiro.user.model.UserUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int signupUser(UserSignupDto dto);

    String signinUser(String email);

    int updateUser(UserUpdDto dto);

}
