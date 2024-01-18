package com.green.gogiro.butchershop;


import com.green.gogiro.butchershop.model.*;
import com.green.gogiro.common.Const;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Operation(summary = "후기 등록",description = "후기 등록 처리")
    public ButcherReviewPIcsInsDto postButReview(@RequestPart(required = false) List<MultipartFile> pics, @RequestPart ButcherReviewDto dto){
        dto.setPics(pics);
        if(dto.getPics() == null || dto.getPics().isEmpty()){
            throw new RestApiException(AuthErrorCode.MUST_PHOTO);
        }
        return service.postButReview(dto);
    }

    @GetMapping("/{ibutcher}")
    @Operation(summary = "정육점 상세 보기",description = "정육점 상세 보기 처리")
    public ButcherShopDetailVo getButDetail(@PathVariable int ibutcher){
        return service.getShopDetail(ibutcher);
    }

    @PostMapping("/bookmark")
    @Operation(summary = "정육점 북마크 ON/OFF",description = "정육점 북마크 토글 처리")
    public ResVo toggleButcherBookmark(@RequestBody ButcherBookmarkDto dto) {
        return service.toggleButcherBookmark(dto);
    }

}
