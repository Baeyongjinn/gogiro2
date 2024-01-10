package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationController {
    private final ReservationService service;

    @PostMapping("/reservation")
    public ResVo postReservation(ReservationInsDto dto){
        return service.postReservation(dto);
    }
    @PostMapping("/pickup")
    public ResVo postPickup(PickupInsDto dto){
        return service.postPickup(dto);
    }
    @GetMapping("/reservation/{iuser}")
    public List<ReservationList> getReservation(@PathVariable int iuser){
        return service.getReservation(iuser);
    }
    @DeleteMapping("/reservation")
    public ResVo deleteReservation(ReservationDelDto dto){
        return service.deleteReservation(dto);
    }
    @DeleteMapping("/pickup")
    public ResVo deletePickup(PickupDelDto dto){
        return service.deletePickup(dto);
    }
}
