package com.green.gogiro.user;

import static com.green.gogiro.common.Const.*;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.user.model.ReservationVo;
import com.green.gogiro.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public List<ReservationVo> getReservation(int iuser){
        return mapper.selReservation(iuser);
    }

    public List<ReviewVo> getUserReview(int iuser){
        List<ReviewVo> reviews= mapper.selUserReview(iuser);
        List<ReviewPk> reviewPkList= new ArrayList<>();
        Map<ReviewPk, ReviewVo> reviewMap= new HashMap<>();
        for(ReviewVo vo: reviews){
            ReviewPk pk= new ReviewPk(vo.getCheckShop(),vo.getIreview());
            reviewMap.put(pk, vo);
            reviewPkList.add(pk);
        }
        for(ReviewPk pk: reviewPkList){
            List<String> pics= mapper.selUserReviewPic(pk);
            reviewMap.get(pk).setPics(pics);
        }
        return reviews;
    }

    public List<BookmarkShopVo> getUserBookmark(int iuser){
        return mapper.selUserBookmark(iuser);
    }
}
