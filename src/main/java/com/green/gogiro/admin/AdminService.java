package com.green.gogiro.admin;

import com.green.gogiro.admin.model.*;
import com.green.gogiro.common.MyFileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {
    private final AdminMapper mapper;
    private final MyFileUtils myFileUtils;

    public StoreRegistrationPicsVo insRegistration(StoreRegistrationDto dto) {

        mapper.insStoreRegistration(dto);

        String target = "/admin/shop/" + dto.getIshop() + "/shop_pic";
        StoreRegistrationPicsVo vo = new StoreRegistrationPicsVo();
        vo.setIshop(dto.getIshop());

        for (MultipartFile file : dto.getPics()) {
            String saveFileNm = myFileUtils.transferTo(file, target);
            vo.getPics().add(saveFileNm);
        }

        mapper.insStoreRegistrationPics(vo);
        return vo;
    }

    public ShopMenuPicsVo insShopMenu(ShopMenuDto dto) {

        String target = "/shop/" + dto.getIshop() + "/menu";
        String fileNm = myFileUtils.transferTo(dto.getPic(), target);
        dto.setFileNm(fileNm);
        mapper.insShopMenu(dto);
        ShopMenuPicsVo vo = new ShopMenuPicsVo();
        vo.setIshop(dto.getIshop());
        vo.setPic(fileNm);
        vo.setImenu(dto.getImenu());
        return vo;
    }

    public ShopMenuPicsVo updShopMenu(ShopMenuUpdDto dto) {
        String picNm = mapper.selPicNm(dto.getImenu());
        log.info("picNm: {}",picNm);
        String target = "/shop/" + dto.getIshop() + "/menu";
        myFileUtils.delFolderTrigger2(target + "/" + picNm);


        String fileNm = myFileUtils.transferTo(dto.getPic(), target);
        dto.setFileNm(fileNm);
        mapper.updShopMenu(dto);
        ShopMenuPicsVo vo = new ShopMenuPicsVo();
        vo.setIshop(dto.getIshop());
        vo.setPic(fileNm);
        vo.setImenu(dto.getImenu());
        return vo;
    }
}
