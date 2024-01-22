package com.green.gogiro.admin;


import com.green.gogiro.admin.model.StoreRegistrationDto;
import com.green.gogiro.admin.model.StoreRegistrationPicsVo;
import com.green.gogiro.exception.RestApiException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.green.gogiro.exception.AuthErrorCode.MUST_PHOTO;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService service;

    @PostMapping("/shop")
    @Operation(summary = "가게 등록",description = "가게 등록 처리")
    public StoreRegistrationPicsVo insRegistration(@RequestPart(required = false) List<MultipartFile> pics, @RequestPart StoreRegistrationDto dto){
        dto.setPics(pics);
        if (dto.getPics() == null || dto.getPics().isEmpty()) {
            throw new RestApiException(MUST_PHOTO);
        }
        return service.insRegistration(dto);
    }

}
