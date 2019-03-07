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
import com.bnau.cdb.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@AutoConfigureMockMvc
@Transactional
public class CompanyControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findCompaniesTest() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/api/companies")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.content", hasSize(greaterThan(0))));
		// @formatter:on
	}

	@Test
	public void findCompanyByIdTest() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/api/companies/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.name", equalTo("Apple Inc.")));
		// @formatter:on
	}

	@Test
	public void updateCompanyTest() throws Exception {
		final CompanyDto company = new CompanyDto(1L, "Test name");

		final String requestJson = TestUtil.dtoToJson(company);

		// @formatter:off
		this.mockMvc.perform(post("/api/companies")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void deleteCompanyTest() throws Exception {
		// @formatter:off
		this.mockMvc.perform(delete("/api/companies/1"))
				.andExpect(status().isOk());
		// @formatter:on
	}

	@Test
	public void addCompanyTest() throws Exception {
		final CompanyDto company = new CompanyDto();
		company.setName("Test company");
		final String requestJson = TestUtil.dtoToJson(company);

		// @formatter:off
		this.mockMvc.perform(put("/api/companies")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()));
		// @formatter:on
	}
}
