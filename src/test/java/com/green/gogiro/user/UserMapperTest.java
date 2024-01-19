package com.green.gogiro.user;

import com.green.gogiro.reservation.ReservationMapper;
import com.green.gogiro.reservation.model.PickupInsDto;
import com.green.gogiro.reservation.model.ReservationInsDto;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.user.model.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.junit.jupiter.api.Assertions.*;
import com.green.gogiro.common.Const;

import java.util.List;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserMapperTest {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Test
    void signupUserTest() {
        UserSignupDto dto = new UserSignupDto();
        String email= "bnlfgnb@sln.cmo";
        dto.setEmail(email);
        String upw= "fnonvoif";
        dto.setUpw(upw);
        String name= "카카카";
        dto.setName(name);
        String nickname= "파파파파파";
        dto.setNickname(nickname);
        String birth= "1234-11-11";
        dto.setBirth(birth);
        String gender= "남";
        dto.setGender(gender);
        String address="라라";
        dto.setAddress(address);

        dto.setTel("010-4848-9898");

        assertEquals(Const.SUCCESS, mapper.signupUser(dto));
        assertTrue(dto.getIuser()>0);

        UserInfoVo vo= mapper.selUserInfo(dto.getIuser());

        assertEquals(email,vo.getEmail());
        assertEquals(name,vo.getName());
        assertEquals(nickname,mapper.checkNickname(vo.getNickname()));
        assertEquals(birth,vo.getBirth());
        assertEquals(gender,vo.getGender());
        assertEquals(address,vo.getAddress());
    }

    @Test
    void updUserPic() {
        int iuser= mapper.selIuserForTest();

        UserInfoVo before= mapper.selUserInfo(iuser);
        String pic= (before.getPic()==null)? "abc.jpg": null;

        UserSignupDto dto = new UserSignupDto();
        dto.setIuser(iuser);
        dto.setPic(pic);

        assertEquals(Const.SUCCESS, mapper.updUserPic(dto));

        UserInfoVo result= mapper.selUserInfo(iuser);
        assertEquals(pic, result.getPic());
    }

    @Test
    void updateUser() {
        int iuser= mapper.selIuserForTest();

        UserInfoVo before= mapper.selUserInfo(iuser);
        String nickname= "테스트용 닉네임";
        String address= "테스트용 주소";
        String pic= (before.getPic()==null)? "abc.jpg": null;
        String tel= "010-1234-5678";

        UserUpdDto dto = new UserUpdDto();
        dto.setIuser(iuser);
        dto.setNickname(nickname);
        dto.setAddress(address);
        dto.setPic(pic);
        dto.setTel(tel);

        assertEquals(Const.SUCCESS, mapper.updateUser(dto));

        UserInfoVo after= mapper.selUserInfo(iuser);
        assertEquals(nickname, after.getNickname());
        assertEquals(address, after.getAddress());
        assertEquals(pic, after.getPic());
        assertEquals(tel, after.getTel());
    }

    @Test
    void selReservation() {
        int iuser1= mapper.selIuserForTest();
        int ishop= shopMapper.selIshopForTest();
        String date1= "1234-12-23 12:12:12";
        String request1= "테스트1234";
        int headCount1= 12;
        ReservationInsDto dto1= new ReservationInsDto();
        dto1.setIuser(iuser1);
        dto1.setIshop(ishop);
        dto1.setDate(date1);
        dto1.setRequest(request1);
        dto1.setHeadCount(headCount1);
        int insert1= reservationMapper.insReservation(dto1);
        assertEquals(1, insert1);
        UserMyPageDto uDto1= new UserMyPageDto();
        uDto1.setIuser(iuser1);
        List<ReservationVo> list1 = mapper.selReservation(uDto1);
        assertEquals(date1, list1.get(0).getDate());
        assertEquals(request1, list1.get(0).getRequest());

        int iuser2= mapper.selIuserForTest();
        int ibutcher= shopMapper.selIshopForTest();
        String date2= "1234-12-23 12:12:12";
        String request2= "테스트1234";
        PickupInsDto dto2= new PickupInsDto();
        dto2.setIuser(iuser2);
        dto2.setIbutcher(ibutcher);
        dto2.setDate(date2);
        dto2.setRequest(request2);
        int insert= reservationMapper.insPickup(dto2);
        assertEquals(1, insert);
        UserMyPageDto uDto= new UserMyPageDto();
        uDto.setIuser(iuser2);
        List<ReservationVo> list2 = mapper.selReservation(uDto);
        assertEquals(date2, list2.get(0).getDate());
        assertEquals(request2, list2.get(0).getRequest());
    }

    @Test
    void selUserReview() {

    }

    @Test
    void selUserReviewPic() {
    }

    @Test
    void selUserBookmark() {
    }

    @Test
    void delShopReviewPics() {
    }

    @Test
    void delShopReview() {
    }
}