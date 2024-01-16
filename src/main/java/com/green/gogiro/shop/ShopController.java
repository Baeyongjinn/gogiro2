package com.green.gogiro.shop;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.shop.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shop")
public class ShopController {
    private final ShopService service;

    @GetMapping
    @Operation(summary = "고기집 리스트 보기",description = "고기집 리스트 보기 처리")
    public List<ShopSelVo> getShopList(ShopSelDto dto) {
        return service.getShopList(dto);
    }

    @GetMapping("/{ishop}")
    @Operation(summary = "고기집 상세 보기",description = "고기집 상세 보기 처리")
    public List<ShopDetailVo> getShopDetail(@PathVariable int ishop){
        return service.getShopDetail(ishop);
    }

    @PostMapping
    @Operation(summary = "리뷰 등록",description = "리뷰 등록 처리")
    public ResVo postShopReview(@RequestBody ShopReviewDto dto) {
        return service.postShopReview(dto);
    }

    @PostMapping("/bookmark")
    @Operation(summary = "고기집 북마크 ON/OFF",description = "고기집 북마크 토글 처리")
    public ResVo toggleShopBookmark(@RequestBody ShopBookmarkDto dto) {
        return service.toggleShopBookmark(dto);
    }
}
