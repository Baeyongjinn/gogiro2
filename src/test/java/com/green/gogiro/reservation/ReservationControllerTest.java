package com.green.gogiro.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.green.gogiro.MockMvcConfig;
import com.green.gogiro.common.ResVo;
import com.green.gogiro.reservation.model.CancelPickupDto;
import com.green.gogiro.reservation.model.CancelReservationDto;
import com.green.gogiro.reservation.model.PickupInsDto;
import com.green.gogiro.reservation.model.ReservationInsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockMvcConfig
@WebMvcTest(ReservationController.class)
class ReservationControllerTest {
    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper mapper;
    @MockBean private ReservationService service;

    @Test
    void postReservation() throws Exception{
        ResVo result= new ResVo(1234);
        given(service.postReservation(any())).willReturn(result);

        ReservationInsDto dto= new ReservationInsDto();

        mvc.perform(MockMvcRequestBuilders.post("/api/reservation") //방식 post, get 등등
                                          .contentType(MediaType.APPLICATION_JSON) // 데이터를 제이슨으로 날리면 필수
                                          .content(mapper.writeValueAsString(dto)) // 바디 부분 dto객체를 제이슨으로 변환하여 날림
                    ).andExpect(status().isOk())
                     .andExpect(content().string(mapper.writeValueAsString(result)))
                     .andDo(print());

        verify(service).postReservation(any());
    }

    @Test
    void postPickup() throws Exception{
        ResVo result= new ResVo(1234);
        given(service.postPickup(any())).willReturn(result);

        PickupInsDto dto= new PickupInsDto();

        mvc.perform(MockMvcRequestBuilders.post("/api/pickup") //방식 post, get 등등
                        .contentType(MediaType.APPLICATION_JSON) // 데이터를 제이슨으로 날리면 필수
                        .content(mapper.writeValueAsString(dto)) // 바디 부분 dto객체를 제이슨으로 변환하여 날림
                ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());

        verify(service).postPickup(any());
    }

    @Test
    void cancelReservation() throws Exception{
        ResVo result= new ResVo(1234);
        given(service.cancelReservation(any())).willReturn(result);

        CancelReservationDto dto= new CancelReservationDto();

        mvc.perform(MockMvcRequestBuilders.patch("/api/reservation") //방식 post, get 등등
                        .contentType(MediaType.APPLICATION_JSON) // 데이터를 제이슨으로 날리면 필수
                        .content(mapper.writeValueAsString(dto)) // 바디 부분 dto객체를 제이슨으로 변환하여 날림
                ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());

        verify(service).cancelReservation(any());
    }

    @Test
    void cancelPickup() throws Exception{
        ResVo result= new ResVo(1234);
        given(service.cancelPickup(any())).willReturn(result);

        CancelPickupDto dto= new CancelPickupDto();

        mvc.perform(MockMvcRequestBuilders.patch("/api/pickup") //방식 post, get 등등
                        .contentType(MediaType.APPLICATION_JSON) // 데이터를 제이슨으로 날리면 필수
                        .content(mapper.writeValueAsString(dto)) // 바디 부분 dto객체를 제이슨으로 변환하여 날림
                ).andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(result)))
                .andDo(print());

        verify(service).cancelPickup(any());
    }
}