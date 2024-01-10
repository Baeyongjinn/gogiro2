package com.green.gogiro.butchershop;


import com.green.gogiro.butchershop.model.ButcherReviewDto;
import com.green.gogiro.butchershop.model.ButcherSelDto;
import com.green.gogiro.butchershop.model.ButcherSelVo;
import com.green.gogiro.butchershop.model.ButcherShopDetailVo;
import com.green.gogiro.common.ResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/butcher-shop")
public class ButcherShopController {
    private final ButcherShopService service;


    @GetMapping
    @Operation(summary = "정육점 리스트 보기",description = "정육점 리스트 보기 처리")
    public List<ButcherSelVo> getButList(ButcherSelDto dto){
        return service.getButList(dto);
    }

    @PostMapping
    @Operation(summary = "리뷰 등록",description = "리뷰 등록 처리")
    public ResVo postButReview(@RequestBody ButcherReviewDto dto){
        return service.postButReview(dto);
    }

    @GetMapping("/{ibutcher}")
    @Operation(summary = "정육점 상세 보기",description = "정육점 상세 보기 처리")
    public List<ButcherShopDetailVo> getShopDetail(@PathVariable int ibutcher){
        return service.getShopDetail(ibutcher);
    }

}
