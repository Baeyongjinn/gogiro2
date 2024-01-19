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

    }

    @Test
    void postPickupTest() throws Exception{

    }

    @Test
    void cancelReservationTest() throws Exception{

    }

    @Test
    void cancelPickupTest() throws Exception{

    }
}