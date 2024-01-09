package com.green.gogiro.user;

import static com.green.gogiro.common.Const.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.errortest.CategoryNotFoundException;
import com.green.gogiro.kakao.KakaoMapper;
import com.green.gogiro.kakao.KakaoService;
import com.green.gogiro.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;

import static com.green.gogiro.errortest.ErrorCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


    public ResVo signup(UserSignupDto dto){
        String checkNickname = mapper.checkNickname(dto.getNickname());
        if(checkNickname != null){
            throw new CategoryNotFoundException("이미 존재 하는 닉네임 입니다");
        }
        if(!dto.getUpw().equals(dto.getCheckUpw())){
            throw new CategoryNotFoundException("비밀번호가 일치하지 않습니다.");
        }
        String hashedPw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(hashedPw);
        mapper.signupUser(dto);
        int result = dto.getIuser();
        log.info("dto: {}",dto);
        //iuser값 return
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
        return new ResVo(SUCCESS);
    }

    public ResVo updateUser(UserUpdDto dto) {
        UserEntity entity = mapper.userEntity(dto.getIuser());
        if(entity == null) {
            throw new CategoryNotFoundException(NULL_USER_ERROR);
        }
        mapper.updateUser(dto);
        return new ResVo(SUCCESS);
    }

    public UserInfoVo selUserInfo(int iuser){
        UserEntity entity = mapper.userEntity(iuser);

        if(entity == null){
            throw new CategoryNotFoundException(NULL_USER_ERROR);
        }
        return mapper.selUserInfo(iuser);
    }

}
