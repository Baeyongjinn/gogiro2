package com.green.gogiro.user;

import static com.green.gogiro.common.Const.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.kakao.KakaoMapper;
import com.green.gogiro.kakao.KakaoService;
import com.green.gogiro.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;



@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;


    public ResVo signup(UserSignupDto dto){
        String checkNickname = mapper.checkNickname(dto.getNickname());

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
            new ResVo(3);
        }
        if (!(BCrypt.checkpw(dto.getUpw(),check))) {
            new ResVo(2);
        }
        return new ResVo(SUCCESS);
    }

    public ResVo updateUser(UserUpdDto dto) {
        UserEntity entity = mapper.userEntity(dto.getIuser());
        if(entity == null) {
            new ResVo(0);
        }
        mapper.updateUser(dto);
        return new ResVo(SUCCESS);
    }

    public UserInfoVo selUserInfo(int iuser){
        UserEntity entity = mapper.userEntity(iuser);
        return mapper.selUserInfo(iuser);
    }

}
