package com.payconiq.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.payconiq.entity.Stock;
import com.payconiq.repo.StockRepository;
import com.payconiq.service.StockService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StockController.class)
class StockControllerTest {
	
	@MockBean
	StockService stockService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@MockBean
	StockRepository stockRepository;
	Timestamp timestamp_1 = Timestamp.valueOf(LocalDateTime.of(LocalDate.of(2018, 10, 7), LocalTime.of(8, 45, 0)));
	Timestamp timestamp_2 = Timestamp.valueOf(LocalDateTime.of(LocalDate.of(2019, 10, 7), LocalTime.of(8, 45, 0)));
	Timestamp timestamp_3 = Timestamp.valueOf(LocalDateTime.of(LocalDate.of(2022, 10, 7), LocalTime.of(8, 45, 0)));
	Stock stock_1 = new Stock(1l, "Bluetooth Speaker", new BigDecimal(50.0), timestamp_1);
	Stock stock_2 = new Stock(2l, "Smart TV", new BigDecimal(50.0), timestamp_2);
	Stock stock_3 = new Stock(3l, "Dining Set", new BigDecimal(50.0), timestamp_3);
	

	@Test
	public void testFindAll() throws Exception {
		
		List<Stock> stocks = new ArrayList<>(Arrays.asList(stock_1,stock_2,stock_3));
		
		Mockito.when(stockService.getStocks()).thenReturn(stocks);
		
		mockMvc.perform(MockMvcRequestBuilders 
						.get("/api/stocks")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$", Matchers.hasSize(3)))
						.andExpect(jsonPath("$[1].name", Matchers.is("Smart TV")));
		
	}
	
	@Test
	public void testById() throws Exception {
		Mockito.when(stockService.getStockById(stock_1.getId())).thenReturn(stock_1);
		
		mockMvc.perform(MockMvcRequestBuilders
						.get("/api/stocks/1").contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$",notNullValue()))
						.andExpect(jsonPath("$.name", is("Bluetooth Speaker")));	
	}
	
	@Test
	public void testCreateStock() throws Exception{
		
		Mockito.when(stockService.createStock(stock_1)).thenReturn(stock_1);
		
		MockHttpServletRequestBuilder mockReq = MockMvcRequestBuilders.post("/api/stocks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(stock_1));
		
		mockMvc.perform(mockReq)
					.andExpect(status().isOk());
					//.andExpect(jsonPath("$", notNullValue()))
					//.andExpect(jsonPath("$.name", is("Bluetooth Speaker")));
					
		
	}
	
	 static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
	

}




