package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.CommunityDelDto;
import com.green.gogiro.community.model.CommunityInsDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping()
    @Operation(summary = "커뮤니티 삭제",description = "커뮤니티 삭제 처리")
    public ResVo delCommunity(CommunityDelDto dto) {
        return service.delCommunity(dto);
    }
}
