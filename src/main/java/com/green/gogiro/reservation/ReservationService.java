package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper mapper;


    public ResVo postReservation(ReservationInsDto dto){
        return new ResVo(mapper.insReservation(dto));
    }

    public ResVo postPickup(PickupInsDto dto){
        mapper.insPickup(dto);
        for(int i=0 ; i< dto.getIbutMenus().size();i++){
            PickupMenuDto menu= PickupMenuDto.builder()
                    .ipickup(dto.getIpickup())
                    .ibutMenu(dto.getIbutMenus().get(i))
                    .count(dto.getCounts().get(i))
                    .build();


            mapper.insPickupMenu(menu);
        }
        return new ResVo(1);
    }

    public ResVo cancelReservation(CancelReservationDto dto){
        return new ResVo(mapper.cancelReservation(dto));
    }

    public ResVo cancelPickup(CancelPickupDto dto){
        return new ResVo(mapper.cancelPickup(dto));
    }
}
