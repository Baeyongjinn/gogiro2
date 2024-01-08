package com.green.gogiro.user;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo signup(UserSignupDto dto){
        String hashedPw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(hashedPw);
        mapper.insUser(dto);
        int result = dto.getIuser();
        return new ResVo(result);
    }

}
