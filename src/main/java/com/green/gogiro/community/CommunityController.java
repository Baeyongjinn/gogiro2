package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.CommunityDelDto;
import com.green.gogiro.community.model.CommunityInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {
    private final CommunityService service;

    @PostMapping()
    public ResVo postCommunity(@RequestBody CommunityInsDto dto) {
        return service.insCommunity(dto);
    }

    @DeleteMapping()
    public ResVo delCommunity(CommunityDelDto dto) {
        return service.delCommunity(dto);
    }
}
