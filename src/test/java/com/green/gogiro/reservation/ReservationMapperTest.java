package com.green.gogiro.reservation;

import com.green.gogiro.butchershop.ButcherShopMapper;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.user.UserMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.green.gogiro.reservation.model.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationMapperTest {
    @Autowired
    private ReservationMapper mapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ButcherShopMapper butcherMapper;


    @Test
    void insReservationTest() {
        int iuser= userMapper.selIuserForTest();
        int ishop= shopMapper.selIshopForTest();
        String date= "1234-11-11 11:11:11";
        String request= "테스트요청";
        int headCount= 4;
        ReservationInsDto dto= new ReservationInsDto();
        dto.setIuser(iuser);
        dto.setIshop(ishop);
        dto.setDate(date);
        dto.setRequest(request);
        dto.setHeadCount(headCount);

        int insReservation= mapper.insReservation(dto);
        assertEquals(1, insReservation);

        ReservationTestVo vo= mapper.selReservationForTest(dto.getIreser());
        assertEquals(iuser, vo.getIuser());
        assertEquals(ishop, vo.getIshop());
        assertEquals(date, vo.getDate());
        assertEquals(request, vo.getRequest());
        assertEquals(headCount, vo.getHeadCount());
    }

    @Test
    void insPickupTest() {
        int iuser= userMapper.selIuserForTest();
        int ibutcher= butcherMapper.selIbutcherForTest();
        String date= "1234-11-11 11:11:11";
        String request= "테스트요청";
        PickupInsDto dto= new PickupInsDto();
        dto.setIuser(iuser);
        dto.setIbutcher(ibutcher);
        dto.setDate(date);
        dto.setRequest(request);
        List<Integer> menuPk= butcherMapper.selIbutMenuForTest(ibutcher);
        List<Integer> count= new ArrayList<>();
        List<PickupMenuDto> menus= new ArrayList<>();
        for(int i=1;i<= menuPk.size();i++) {
            count.add(i);
            PickupMenuDto menu= PickupMenuDto.builder()
                    .ibutMenu(menuPk.get(i-1)).count(count.get(i-1)).build();
            menus.add(menu);
        }
        dto.setMenus(menus);
        int insPickup= mapper.insPickup(dto);
        assertEquals(1, insPickup);
        for(PickupMenuDto menu: menus) {
            menu.setIpickup(dto.getIpickup());
            int insPickupPic= mapper.insPickupMenu(menu);
            assertEquals(1, insPickupPic);
        }
        assertEquals(menus.size(), mapper.selPickupMenusForTest(dto.getIpickup()));
    }
    @Test
    void cancelReservationTest() {
        CancelReservationDto dto= mapper.selReservationForCancelTest();
        int cancelReservation= mapper.cancelReservation(dto);
        assertEquals(1, cancelReservation);
        assertEquals(1,mapper.selReservationConfirmForTest(dto.getIreser()));
    }
    @Test
    void cancelPickupTest() {
        CancelPickupDto dto= mapper.selPickupForCancelTest();
        int cancelPickup= mapper.cancelPickup(dto);
        assertEquals(1, cancelPickup);
        assertEquals(1,mapper.selPickupConfirmForTest(dto.getIpickup()));
    }
    @Test
    void updReservationTest() {
        CancelReservationDto dto= mapper.selReservationForCancelTest();
        ReservationUpdDto updDto= new ReservationUpdDto();
        updDto.setIreser(dto.getIreser());
        String date= "1234-11-11 11:11:11";
        String request= "테스트요청";
        int headCount= 4;
        updDto.setDate(date);
        updDto.setRequest(request);
        updDto.setHeadCount(headCount);
        int updReservation= mapper.updReservation(updDto);
        assertEquals(1, updReservation);
        ReservationTestVo vo= mapper.selReservationForTest(dto.getIreser());
        assertEquals(date, vo.getDate());
        assertEquals(request, vo.getRequest());
        assertEquals(headCount, vo.getHeadCount());
    }
}