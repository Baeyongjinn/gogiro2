package com.green.gogiro.reservation;

import com.green.gogiro.reservation.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    int insReservation(ReservationInsDto dto);

    int insPickup(PickupInsDto dto);

    int insPickupMenu(PickupMenuDto dto);

    int cancelReservation(CancelReservationDto dto);

    int cancelPickup(CancelPickupDto dto);

    int updReservation(ReservationUpdDto dto);

    ReservationTestVo selReservationForTest(int ireser);

    int selPickupMenusForTest(int ipickup);

    CancelReservationDto selReservationForCancelTest();

    int selReservationConfirmForTest(int ireser);

    CancelPickupDto selPickupForCancelTest();

    int selPickupConfirmForTest(int ipickup);
}
