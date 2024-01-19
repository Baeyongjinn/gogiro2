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
}
