package com.bnau.cdb.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bnau.cdb.CdbApplication;
import com.bnau.cdb.dto.CompanyDto;
import com.bnau.cdb.dto.ComputerDto;
import com.bnau.cdb.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@AutoConfigureMockMvc
@Transactional
public class ComputerControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void findComputersTest() throws Exception {
		// @formatter:off
		mockMvc.perform(get("/api/computers")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.content", hasSize(greaterThan(0))));
		// @formatter:on
	}
	
	@Test
	public void findComputerByIdTest() throws Exception {
		// @formatter:off
		mockMvc.perform(get("/api/computers/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.name", equalTo("MacBook Pro 15.4 inch")));
		// @formatter:on
	}
	
	@Test
	public void updateComputerTest() throws Exception {
		final ComputerDto computer = new ComputerDto(2L, "Computer Test", LocalDate.of(2000, Month.JANUARY, 1),
				LocalDate.of(2001, Month.JANUARY, 1), new CompanyDto(3L, "Useless name"));
		
		final String requestJson = TestUtil.dtoToJson(computer);
		
		// @formatter:off
		mockMvc.perform(post("/api/computers")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk());
		// @formatter:on
	}
	
	@Test
	public void updateComputerTestIntroductedAfterDiscontinued() throws Exception {
		final ComputerDto computer = new ComputerDto(2L, "Computer Test", LocalDate.of(2001, Month.JANUARY, 1),
				LocalDate.of(2000, Month.JANUARY, 1), new CompanyDto(3L, "Useless name"));
		
		final String requestJson = TestUtil.dtoToJson(computer);
		
		// @formatter:off
		mockMvc.perform(post("/api/computers")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isBadRequest());
		// @formatter:on
	}
	
	@Test
	public void deleteComputerTest() throws Exception {
		// @formatter:off
		mockMvc.perform(delete("/api/computers/1"))
				.andExpect(status().isOk());
		// @formatter:on
	}
	
	@Test
	public void addComputerTest() throws Exception {
		final ComputerDto computer = new ComputerDto(2L, "Computer Test", LocalDate.of(2000, Month.JANUARY, 1),
				LocalDate.of(2001, Month.JANUARY, 1), new CompanyDto(3L, "Useless name"));
		computer.setId(null);
		final String requestJson = TestUtil.dtoToJson(computer);
		
		// @formatter:off
		mockMvc.perform(put("/api/computers")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()));
		// @formatter:on
	}
	
	@Test
	public void addComputerTestIntroductedAfterDiscontinued() throws Exception {
		final ComputerDto computer = new ComputerDto(2L, "Computer Test", LocalDate.of(2001, Month.JANUARY, 1),
				LocalDate.of(2000, Month.JANUARY, 1), new CompanyDto(3L, "Useless name"));
		computer.setId(null);
		final String requestJson = TestUtil.dtoToJson(computer);
		
		// @formatter:off
		mockMvc.perform(put("/api/computers")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isBadRequest());
		// @formatter:on
	}
}
