package com.green.gogiro.admin;

import com.green.gogiro.admin.model.StoreRegistrationDto;
import com.green.gogiro.admin.model.StoreRegistrationPicsVo;
import com.green.gogiro.common.MyFileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper mapper;
    private final MyFileUtils myFileUtils;

    public StoreRegistrationPicsVo insRegistration(StoreRegistrationDto dto){

        mapper.insStoreRegistration(dto);

        String target = "/admin/shop/" + dto.getIshop();
        StoreRegistrationPicsVo vo = new StoreRegistrationPicsVo();
        vo.setIshop(dto.getIshop());

        for(MultipartFile file : dto.getPics()){
            String saveFileNm =  myFileUtils.transferTo(file,target);
            vo.getPics().add(saveFileNm);
        }

        mapper.insStoreRegistrationPics(vo);
        return vo;
    }
}
