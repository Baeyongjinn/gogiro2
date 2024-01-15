package com.green.gogiro.reservation;

import com.green.gogiro.BaseIntegrationTest;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.CancelPickupDto;
import com.green.gogiro.reservation.model.CancelReservationDto;
import com.green.gogiro.reservation.model.PickupInsDto;
import com.green.gogiro.reservation.model.ReservationInsDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
public class ReservationIntegrationTest extends BaseIntegrationTest {
    @Test
    void postReservation() throws Exception{
        ReservationInsDto dto= new ReservationInsDto();
        dto.setIuser(4);
        dto.setIshop(1);
        dto.setDate("1234-11-12");
        dto.setRequest("요오오청");
        dto.setHeadCount(1);
        String json= om.writeValueAsString(dto);

        MvcResult mr= mvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content= mr.getResponse().getContentAsString();
        ResVo rv= om.readValue(content, ResVo.class);
        assertEquals(1, rv.getResult());
    }

    @Test
    void postPickup() throws Exception{
        PickupInsDto dto= new PickupInsDto();
        dto.setIuser(4);
        dto.setIbutcher(1);
        dto.setDate("1234-11-12");
        dto.setRequest("요오오청");
        List<Integer> menu= new ArrayList<>();
        menu.add(1);
        List<Integer> count= new ArrayList<>();
        count.add(2);
        dto.setIbutMenus(menu);
        dto.setCounts(count);

        String json= om.writeValueAsString(dto);

        MvcResult mr= mvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/pickup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content= mr.getResponse().getContentAsString();
        ResVo rv= om.readValue(content, ResVo.class);
        assertEquals(1, rv.getResult());
    }

    @Test
    void cancelReservation() throws Exception{
        CancelReservationDto dto= new CancelReservationDto();
        dto.setIreser(2);
        dto.setIuser(4);

        String json= om.writeValueAsString(dto);

        MvcResult mr= mvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/reservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content= mr.getResponse().getContentAsString();
        ResVo rv= om.readValue(content, ResVo.class);
        assertEquals(1, rv.getResult());
    }



    @Test
    void cancelPickup() throws Exception{
        CancelPickupDto dto= new CancelPickupDto();
        dto.setIpickup(1);
        dto.setIuser(4);

        String json= om.writeValueAsString(dto);

        MvcResult mr= mvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/pickup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content= mr.getResponse().getContentAsString();
        ResVo rv= om.readValue(content, ResVo.class);
        assertEquals(1, rv.getResult());
    }
}
