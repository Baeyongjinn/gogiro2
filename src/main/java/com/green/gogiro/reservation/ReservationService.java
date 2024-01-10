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
        for(int i=0;i<dto.getIbut_menu().size();i++){
            mapper.insPickupMenu(dto.getIpickup(),
                                 dto.getIbut_menu().get(i),
                                 dto.getCount().get(i));
        }
        return new ResVo(1);
    }

    public List<ReservationList> getReservation(int iuser){
        return mapper.selReservation(iuser);
    }

    public ResVo deleteReservation(ReservationDelDto dto){
        return new ResVo(mapper.delReservation(dto));
    }

    public ResVo deletePickup(PickupDelDto dto){
        return new ResVo(mapper.delPickup(dto));
    }
}
