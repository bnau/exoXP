package com.bnau.cdb.controller;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bnau.cdb.CdbApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@AutoConfigureMockMvc
public class CompanyControllerTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findCompaniesTest() throws Exception {
		// @formatter:off
		this.mockMvc.perform(get("/api/companies"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.content", hasSize(greaterThan(0))));
		// @formatter:on
	}
}
