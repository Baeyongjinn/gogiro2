package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.errortest.CategoryNotFoundException;
import com.green.gogiro.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static com.green.gogiro.errortest.ErrorCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo signup(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(hashedPw);
        mapper.signupUser(dto);
        int result = dto.getIuser();
        log.info("dto: {}",dto);
        return new ResVo(result);
    }

    //1:성공 , 2:비밀번호 다름, 3:아이디없음
    public ResVo signin(UserSigninDto dto){
        String check = mapper.signinUser(dto.getEmail());
        if(check == null){
            throw new CategoryNotFoundException(SIGNIN_UID_ERROR);
        }
        if (!(BCrypt.checkpw(dto.getUpw(),check))) {
            throw new CategoryNotFoundException(SIGNIN_UPW_ERROR);
        }
        return new ResVo(1);
    }

    public ResVo updateUser(UserUpdDto dto) {
        int result = mapper.updateUser(dto);
        return new ResVo(result);
    }

    public UserInfoVo selUserInfo(int iuser){
        UserEntity entity = mapper.userEntity(iuser);
        if(entity == null){
            throw new CategoryNotFoundException(NULL_USER_ERROR);
        }
        return mapper.selUserInfo(iuser);
    }
}
