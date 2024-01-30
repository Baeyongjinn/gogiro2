package com.green.gogiro.reservation;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Tag(name = "예약(픽업)",description = "예약(픽업) API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationController {
    private final ReservationService service;

    @PostMapping("/reservation")
    @Operation(summary = "예약 등록",description = "예약 등록 처리")
    public ResVo postReservation(@RequestBody @Valid ReservationInsDto dto){
        return service.postReservation(dto);
    }

    @PostMapping("/pickup")
    @Operation(summary = "픽업 등록",description = "픽업 등록 처리")
    public ResVo postPickup(@RequestBody @Valid PickupInsDto dto){
        return service.postPickup(dto);
    }

    @PatchMapping("/reservation")
    @Operation(summary = "예약 취소",description = "예약 취소 처리")
    public ResVo cancelReservation(@RequestBody @Valid CancelDto dto){
        return service.cancelReservation(dto);
    }

    @PutMapping("/reservation")
    @Operation(summary = "예약 변경",description = "예약 변경 처리")
    public ResVo putReservation(@RequestBody @Valid ReservationUpdDto dto) {
        return service.putReservation(dto);
    }
}
