package com.green.gogiro.reservation;

import com.green.gogiro.reservation.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    int insReservation(ReservationInsDto dto);
    int insPickup(PickupInsDto dto);
    int insPickupMenu(int ipickup, int ibutcherMenu, int count);
    List<ReservationList> selReservation(int iuser);
    int delReservation(ReservationDelDto dto);
    int delPickup(PickupDelDto dto);
}
