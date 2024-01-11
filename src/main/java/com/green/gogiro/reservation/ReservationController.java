package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationController {
    private final ReservationService service;

    @PostMapping("/reservation")
    @Operation(summary = "예약 등록",description = "예약 등록 처리")
    public ResVo postReservation(ReservationInsDto dto){
        return service.postReservation(dto);
    }
    @PostMapping("/pickup")
    @Operation(summary = "픽업 등록",description = "픽업 등록 처리")
    public ResVo postPickup(PickupInsDto dto){
        return service.postPickup(dto);
    }
    @GetMapping("/reservation/{iuser}")
    @Operation(summary = "예약 및 픽업 리스트",description = "회원이 등록한 예약 및 픽업 정보를 리스트로 처리")
    public List<ReservationList> getReservation(@PathVariable int iuser){
        return service.getReservation(iuser);
    }
    @PatchMapping("/reservation")
    @Operation(summary = "예약 취소",description = "예약 취소 처리")
    public ResVo cancelReservation(CancelReservationDto dto){
        return service.cancelReservation(dto);
    }
    @PatchMapping("/pickup")
    @Operation(summary = "픽업 취소",description = "픽업 취소 처리")
    public ResVo cancelPickup(CancelPickupDto dto){
        return service.cancelPickup(dto);
    }
}
