package com.bidbinding.auction.engine.adapter.driver.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@ComponentScan("com.bidbinding")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
//@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PlaceBidAdapterTest {

    @Autowired
    private MockMvc mockMvc;
    ObjectMapper om = new ObjectMapper();


    @Test
    void placeBid() throws Exception {
//        BidPlacementResponse bidPlacementResponse =
//                om.readValue(mockMvc.perform(
//                                MockMvcRequestBuilders.post("/bid")
//                                        .contentType("application/json")
//                                        .content(
//                                                om.writeValueAsString(
//                                                        new BidPlacementRequest("bidder", "dsfkgjhqaklgjqkljhafg", BigDecimal.valueOf(12))
//                                                )
//                                        ))
//                        .andDo(MockMvcResultHandlers.print())
//                        .andReturn().getResponse().getContentAsString(), BidPlacementResponse.class);
//        System.out.println(bidPlacementResponse.getStatus());
    }
}