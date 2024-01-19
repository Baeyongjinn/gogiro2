package com.green.gogiro.admin;

import com.green.gogiro.admin.model.StoreRegistrationDto;
import com.green.gogiro.admin.model.StoreRegistrationPicsVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int insStoreRegistrationPics(StoreRegistrationPicsVo dto);
    int insStoreRegistration(StoreRegistrationDto dto);
}
