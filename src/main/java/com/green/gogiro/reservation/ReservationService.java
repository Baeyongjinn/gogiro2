package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper mapper;


    public ResVo postReservation(ReservationInsDto dto){
        return new ResVo(mapper.insReservation(dto));
    }

    public ResVo postPickup(PickupInsDto dto){
        mapper.insPickup(dto);
        for(PickupMenuDto menu: dto.getMenus()){
            menu.setIbutcher(dto.getIbutcher());
            mapper.insPickupMenu(menu);
        }
        return new ResVo(1);
    }

    public List<ReservationList> getReservation(int iuser){
        return mapper.selReservation(iuser);
    }

    public ResVo cancelReservation(CancelReservationDto dto){
        return new ResVo(mapper.cancelReservation(dto));
    }

    public ResVo cancelPickup(CancelPickupDto dto){
        return new ResVo(mapper.cancelPickup(dto));
    }
}
