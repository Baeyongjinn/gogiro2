package com.green.gogiro.butchershop;


import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.ResVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
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
    public ButcherShopDetailVo getShopDetail(@PathVariable int ibutcher){
        return service.getShopDetail(ibutcher);
    }

    @PostMapping("/bookmark")
    @Operation(summary = "정육점 북마크 ON/OFF",description = "정육점 북마크 토글 처리")
    public ResVo toggleButcherBookmark(@RequestBody ButcherBookmarkDto dto) {
        return service.toggleButcherBookmark(dto);
    }

}
