package com.green.gogiro.reservation;

import static com.green.gogiro.common.Const.*;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper mapper;


    public ResVo postReservation(ReservationInsDto dto) {
        return new ResVo(mapper.insReservation(dto));
    }

    public ResVo postPickup(PickupInsDto dto) {
        mapper.insPickup(dto);
        if (dto.getIbutMenus() != null) {
            for (int i = 0; i < dto.getIbutMenus().size(); i++) {
                PickupMenuDto menu = PickupMenuDto.builder()
                        .ipickup(dto.getIpickup())
                        .ibutMenu(dto.getIbutMenus().get(i))
                        .count(dto.getCounts().get(i))
                        .build();
                mapper.insPickupMenu(menu);
            }
        }
        return new ResVo(SUCCESS);
    }

    public ResVo cancelReservation(CancelReservationDto dto) {
        mapper.cancelReservation(dto);
        return new ResVo(SUCCESS);
    }

    public ResVo cancelPickup(CancelPickupDto dto) {
        mapper.cancelPickup(dto);
        return new ResVo(SUCCESS);
    }
}
