package com.green.gogiro.user;

import com.green.gogiro.user.model.UserSignupDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int insUser(UserSignupDto dto);

}
