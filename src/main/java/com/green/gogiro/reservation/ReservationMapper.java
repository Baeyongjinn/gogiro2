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

    List<ReservationInsDto> selReservationForTest(ReservationInsDto dto);

    List<PickupInsDto> selPickupForTest(PickupInsDto dto);

    List<PickupMenuDto> selPickupMenuForTest(PickupMenuDto dto);

    int selReservationConfirmForTest(CancelReservationDto dto);

    int selPickupConfirmForTest(CancelPickupDto dto);

    int updReservation(ReservationUpdDto dto);

}
