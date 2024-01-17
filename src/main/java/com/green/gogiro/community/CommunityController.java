package com.green.gogiro.community;

import com.green.gogiro.common.ResVo;
import com.green.gogiro.community.model.*;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {
    private final CommunityService service;

    @PostMapping()
    @Operation(summary = "커뮤니티 등록",description = "커뮤니티 등록 처리")
    public CommunityPicsInsVo postCommunity(@RequestPart(required = false) List<MultipartFile> pics
            , @RequestPart CommunityInsDto dto) {
        //사진을 넣지 않는경우
        if(dto.getFiles() == null||dto.getFiles().isEmpty()) {
            throw new RestApiException(AuthErrorCode.MUST_PHOTO);
        }
        //사진을 5장 초과했을 경우
        if(dto.getFiles().size() >= 5){
            throw new RestApiException(AuthErrorCode.SIZE_PHOTO);
        }
        dto.setFiles(pics);
        return service.insCommunity(dto);
    }

    @PutMapping()
    @Operation(summary = "커뮤니티 수정", description = "커뮤니티 수정 처리")
    public CommunityPicsInsVo putCommunity(@RequestPart(required = false) List<MultipartFile> pics
            , @RequestPart CommunityUpdDto dto) {
        //사진을 넣지 않는경우
        if(dto.getFiles() == null||dto.getFiles().isEmpty()) {
            throw new RestApiException(AuthErrorCode.MUST_PHOTO);
        }
        //사진을 5장 초과했을 경우
        if(dto.getFiles().size() >= 5){
            throw new RestApiException(AuthErrorCode.SIZE_PHOTO);
        }
        dto.setFiles(pics);
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

    @PostMapping("/comment")
    @Operation(summary = "커뮤니티 댓글 작성",description = "커뮤니티 댓글 작성 처리")
    public ResVo postCommunityComment(@RequestBody CommunityCommentInsDto dto) {
        return service.postCommunityComment(dto);
    }

    @DeleteMapping("/comment")
    @Operation(summary = "커뮤니티 댓글 삭제",description = "커뮤니티 댓글 삭제 처리")
    public ResVo delCommunityComment(@RequestBody CommunityCommentDelDto dto) {
        return service.delCommunityComment(dto);
    }


}
