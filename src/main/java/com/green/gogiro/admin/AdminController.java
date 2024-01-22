package com.green.gogiro.admin;


import com.green.gogiro.admin.model.*;
import com.green.gogiro.exception.RestApiException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/shop/menu")
    public ShopMenuPicsVo insShopMenu(@RequestPart(required = false) MultipartFile pic, @RequestPart ShopMenuDto dto){
        if(pic != null) {
            dto.setPic(pic);
        }
        return service.insShopMenu(dto);
    }

    @PutMapping("/shop/menu")
    public ShopMenuPicsVo updShopMenu(@RequestPart(required = false) MultipartFile pic, @RequestPart ShopMenuUpdDto dto) {
        if(pic != null) {
            dto.setPic(pic);
        }
        return service.updShopMenu(dto);
    }

}
