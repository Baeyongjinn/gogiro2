package com.green.gogiro.admin;

import com.green.gogiro.admin.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    int insStoreRegistrationPics(StoreRegistrationPicsVo dto);
    int insStoreRegistration(StoreRegistrationDto dto);

    int insShopMenu(ShopMenuDto dto);

    int updShopMenu(ShopMenuUpdDto dto);

    String selPicNm(int imenu);

    int insButcherShop(ButcherInsDto dto);

    int insButcherPics(ButcherInsDto dto);

    int insButcherMenu(ButcherMenuInsDto dto);

    String selButcherMenuPicNm(int ibutMenu);

    int updButcherMenu(ButcherMenuUpdDto dto);


}
