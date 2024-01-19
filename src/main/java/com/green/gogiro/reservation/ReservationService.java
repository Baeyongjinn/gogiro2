package com.green.gogiro.reservation;

import static com.green.gogiro.common.Const.*;

import com.green.gogiro.common.Const;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.exception.AuthErrorCode;
import com.green.gogiro.exception.RestApiException;
import com.green.gogiro.reservation.model.*;
import com.green.gogiro.security.AuthenticationFacade;
import com.green.gogiro.shop.ShopMapper;
import com.green.gogiro.shop.model.ShopEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationMapper mapper;
    private final AuthenticationFacade authenticationFacade;
    private final ShopMapper shopMapper;


    public ResVo postReservation(ReservationInsDto dto) {
        ShopEntity entity = shopMapper.selShopEntity(dto.getIshop());
        if(entity == null){
            throw new RestApiException(AuthErrorCode.VALID_SHOP);
        }if(entity.getIshop() != dto.getIshop()){
            throw new RestApiException(AuthErrorCode.CHECK_SHOP);
        }
        if(dto.getDate().equals("0000-00-00 00:00:00") || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR,dto.getDate())){
            throw new RestApiException(AuthErrorCode.NOT_DATE);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insReservation(dto);
        return new ResVo(dto.getIreser());
    }

    public ResVo postPickup(PickupInsDto dto) {
        if(dto.getDate() == null || Pattern.matches(REGEXP_PATTERN_SPACE_CHAR,dto.getDate()) || !Pattern.matches(REGEXP_DATE_TYPE5,dto.getDate())
        || dto.getDate().equals("0000-00-00 00:00:00")){
            throw new RestApiException(AuthErrorCode.REGEXP_DATE_TYPE);
        }
        if(dto.getIbutMenus() != null || !(dto.getIbutMenus().size() == dto.getCounts().size())) {
            throw new RestApiException(AuthErrorCode.INVALID_MENU_OR_COUNT);
        }
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.insPickup(dto);
            for (int i = 0; i < dto.getIbutMenus().size(); i++) {
                PickupMenuDto menu = PickupMenuDto.builder()
                        .ipickup(dto.getIpickup())
                        .ibutMenu(dto.getIbutMenus().get(i))
                        .count(dto.getCounts().get(i))
                        .build();
                mapper.insPickupMenu(menu);
            }
        return new ResVo(dto.getIpickup());
    }

    public ResVo cancelReservation(CancelReservationDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.cancelReservation(dto);
        return new ResVo(SUCCESS);
    }

    public ResVo cancelPickup(CancelPickupDto dto) {
        dto.setIuser(authenticationFacade.getLoginUserPk());
        mapper.cancelPickup(dto);
        return new ResVo(SUCCESS);
    }
}
