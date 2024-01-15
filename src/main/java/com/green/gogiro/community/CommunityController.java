package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {
    private final CommunityService service;

    @PostMapping()
    @Operation(summary = "커뮤니티 등록",description = "커뮤니티 등록 처리")
    public ResVo postCommunity(@RequestBody CommunityInsDto dto) {
        return service.insCommunity(dto);
    }

    @PutMapping()
    @Operation(summary = "커뮤니티 수정", description = "커뮤니티 수정 처리")
    public ResVo putCommunity(@RequestBody CommunityUpdDto dto) {
        return service.updCommunity(dto);
    }

    @GetMapping()
    @Operation(summary = "커뮤니티 리스트", description = "커뮤니티 리스트 처리")
    public List<CommunitySelVo> getCommunity(CommunitySelDto dto) {
        return service.selCommunity(dto);
    }
    @DeleteMapping()
    @Operation(summary = "커뮤니티 삭제",description = "커뮤니티 삭제 처리")
    public ResVo delCommunity(CommunityDelDto dto) {
        return service.delCommunity(dto);
    }

}
