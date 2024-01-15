package com.green.gogiro.reservation;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import com.green.gogiro.reservation.model.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservationMapperTest {
    @Autowired
    private ReservationMapper mapper;

    @Test
    void insReservationTest() throws Exception{
        ReservationInsDto dto1= new ReservationInsDto();
        dto1.setIuser(4);
        dto1.setIshop(1);
        dto1.setDate("1234-11-11");
        List<ReservationInsDto> result1= mapper.selReservationForTest(dto1);
        assertEquals(0, result1.size());
        int testR1= mapper.insReservation(dto1);
        assertEquals(1, testR1);
        List<ReservationInsDto> result2= mapper.selReservationForTest(dto1);
        assertEquals(1, result2.size());

        ReservationInsDto dto2= new ReservationInsDto();
        dto2.setIuser(5);
        dto2.setIshop(2);
        dto2.setDate("1334-12-21");
        List<ReservationInsDto> result3= mapper.selReservationForTest(dto2);
        assertEquals(0, result3.size());
        int testR2= mapper.insReservation(dto2);
        assertEquals(1, testR2);
        List<ReservationInsDto> result4= mapper.selReservationForTest(dto1);
        assertEquals(1, result4.size());
    }

    @Test
    void insPickupTest() throws Exception{
        PickupInsDto dto1= new PickupInsDto();
        dto1.setIuser(4);
        dto1.setIbutcher(1);
        dto1.setDate("1234-11-11");
        List<PickupInsDto> result1= mapper.selPickupForTest(dto1);
        assertEquals(0, result1.size());
        int testR1= mapper.insPickup(dto1);
        assertEquals(1, testR1);
        List<PickupInsDto> result2= mapper.selPickupForTest(dto1);
        assertEquals(1, result2.size());

        PickupInsDto dto2= new PickupInsDto();
        dto2.setIuser(5);
        dto2.setIbutcher(2);
        dto2.setDate("1334-12-21");
        List<PickupInsDto> result3= mapper.selPickupForTest(dto2);
        assertEquals(0, result3.size());
        int testR2= mapper.insPickup(dto2);
        assertEquals(1, testR2);
        List<PickupInsDto> result4= mapper.selPickupForTest(dto2);
        assertEquals(1, result4.size());
    }

    @Test
    void insPickupMenuTest() throws Exception{
        PickupMenuDto dto1= PickupMenuDto.builder()
                .ipickup(6)
                .ibutMenu(2)
                .build();
        List<PickupMenuDto> result1= mapper.selPickupMenuForTest(dto1);
        assertEquals(0, result1.size());
        int testR1= mapper.insPickupMenu(dto1);
        assertEquals(1, testR1);
        List<PickupMenuDto> result2= mapper.selPickupMenuForTest(dto1);
        assertEquals(1, result2.size());

        PickupMenuDto dto2= PickupMenuDto.builder()
                .ipickup(5)
                .ibutMenu(2)
                .build();
        List<PickupMenuDto> result3= mapper.selPickupMenuForTest(dto2);
        assertEquals(0, result3.size());
        int testR2= mapper.insPickupMenu(dto2);
        assertEquals(1, testR2);
        List<PickupMenuDto> result4= mapper.selPickupMenuForTest(dto1);
        assertEquals(1, result4.size());

    }

    @Test
    void cancelReservationTest() throws Exception{
        CancelReservationDto dto= new CancelReservationDto();
        dto.setIuser(4);
        dto.setIreser(2);
        int confirm= mapper.selReservationConfirmForTest(dto);
        assertEquals(0, confirm);
        int cancel= mapper.cancelReservation(dto);
        assertEquals(1, cancel);
        int confirm2= mapper.selReservationConfirmForTest(dto);
        assertEquals(1, confirm2);
    }

    @Test
    void cancelPickupTest() throws Exception {
        CancelPickupDto dto= new CancelPickupDto();
        dto.setIuser(4);
        dto.setIpickup(2);
        int confirm= mapper.selPickupConfirmForTest(dto);
        assertEquals(0, confirm);
        int cancel= mapper.cancelPickup(dto);
        assertEquals(1, cancel);
        int confirm2= mapper.selPickupConfirmForTest(dto);
        assertEquals(1, confirm2);
    }
}