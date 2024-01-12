package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.CancelPickupDto;
import com.green.gogiro.reservation.model.CancelReservationDto;
import com.green.gogiro.reservation.model.PickupInsDto;
import com.green.gogiro.reservation.model.ReservationInsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ReservationService.class})
class ReservationServiceTest {
    @MockBean
    private ReservationMapper mapper;
    @Autowired
    private ReservationService service;

    @Test
    void postReservationTest() throws Exception{
        final int RESULT= 123;
        given(mapper.insReservation(any())).willReturn(RESULT);
        ReservationInsDto dto= new ReservationInsDto();
        ResVo vo= service.postReservation(dto);
        assertEquals(RESULT, vo.getResult());
        verify(mapper).insReservation(any());
    }

    @Test
    void postPickupTest() throws Exception{
        PickupInsDto dto= new PickupInsDto();
        ResVo vo= service.postPickup(dto);
        assertEquals(333,vo.getResult());
        verify(mapper).insPickup(any());
    }

    @Test
    void cancelReservationTest() throws Exception{
        final int RESULT= 123;
        given(mapper.cancelReservation(any())).willReturn(RESULT);
        CancelReservationDto dto= new CancelReservationDto();
        ResVo vo= service.cancelReservation(dto);
        assertEquals(RESULT, vo.getResult());
    }

    @Test
    void cancelPickupTest() throws Exception{
        final int RESULT= 123;
        given(mapper.cancelPickup(any())).willReturn(RESULT);
        CancelPickupDto dto= new CancelPickupDto();
        ResVo vo= service.cancelPickup(dto);
        assertEquals(RESULT, vo.getResult());
    }
}