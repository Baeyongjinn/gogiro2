package com.green.gogiro.reservation;

import static com.green.gogiro.common.Const.*;

import com.green.gogiro.butchershop.ButcherShopMapper;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.reservation.model.*;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.shop.model.ShopEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper mapper;
    private final AuthenticationFacade authenticationFacade;
    private final ShopMapper shopMapper;
    private final ButcherShopMapper butMapper;


    public ResVo postReservation(ReservationInsDto dto) {
        ShopEntity entity = shopMapper.selShopEntity(dto.getIshop());
        if(entity == null){
            throw new RestApiException(AuthErrorCode.VALID_SHOP);
        } else if(entity.getIshop() != dto.getIshop()){
            throw new RestApiException(AuthErrorCode.CHECK_SHOP);
        }
        if(dto.getDate().equals("0000-00-00 00:00:00")){
            throw new RestApiException(AuthErrorCode.NOT_DATE);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insReservation(dto);
        return new ResVo(dto.getIreser());
    }

    @Transactional
    public ResVo postPickup(PickupInsDto dto) {
        if(dto.getDate() == null || dto.getDate().equals("0000-00-00 00:00:00")){
            throw new RestApiException(AuthErrorCode.REGEXP_DATE_TYPE);
        }
        if(dto.getMenus() == null||dto.getMenus().isEmpty()) {
            throw new RestApiException(AuthErrorCode.INVALID_MENU_OR_COUNT);
        } else {
            List<Integer> menuList= butMapper.selButcherMenu(dto.getIbutcher());
            /*
            List<Integer> list= menuList.stream().filter(item->{
                for(PickupMenuDto menu: dto.getMenus()){
                    if(item==menu.getIbutMenu()){
                        return true;
                    }
                }
                return false;
            }).toList();
            if(list.size()!=dto.getMenus().size()){
                throw new RestApiException(AuthErrorCode.INVALID_MENU_OR_COUNT);
            }
            */
            List<Boolean> check= new ArrayList<>();
            for(PickupMenuDto menu: dto.getMenus()) {
                for(Integer menuPk:menuList) {
                    if(menu.getIbutMenu()==menuPk) {
                        check.add(true);
                    }
                }
            }
            if(check.size()!=dto.getMenus().size()){
                throw new RestApiException(AuthErrorCode.INVALID_MENU_OR_COUNT);
            }
        }

        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insPickup(dto);
            for (PickupMenuDto m: dto.getMenus()) {
                PickupMenuDto menu = PickupMenuDto.builder()
                                                  .ipickup(dto.getIpickup())
                                                  .ibutMenu(m.getIbutMenu())
                                                  .count(m.getCount())
                                                  .build();
                mapper.insPickupMenu(menu);
            }
        return new ResVo(dto.getIpickup());
    }


    public ResVo cancelReservation(CancelDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        Integer checkReservation = mapper.checkReservation(dto);
        if(checkReservation == null){
            throw new RestApiException(AuthErrorCode.INVALID_RESERVATION);
        }
        if(dto.isReservation()){
            mapper.cancelReservation(dto);}
        else{mapper.cancelPickup(dto);}
        return new ResVo(SUCCESS);
    }

    public ResVo putReservation(ReservationUpdDto dto) {
        if(dto.getDate().equals("0000-00-00 00:00:00")){
            throw new RestApiException(AuthErrorCode.NOT_DATE);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.updReservation(dto);
        return new ResVo(SUCCESS);
    }
}
