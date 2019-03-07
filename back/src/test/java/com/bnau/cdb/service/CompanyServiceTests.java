package com.bnau.cdb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnau.cdb.CdbApplication;
import com.bnau.cdb.dto.CompanyDto;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@Transactional
public class CompanyServiceTests {
	
	@Autowired
	CompanyService companyService;
	
	@Test
	public void findCompaniesTest() {
		assertTrue(this.companyService.findCompanies(PageRequest.of(2, 1)).getSize() > 0);
	}

	@Test
	public void findCompanyByIdTest() {
		assertEquals("Apple Inc.", this.companyService.findCompanyById(1L).getName());
	}

	@Test
	public void updateCompanyTest() {
		this.companyService.updateCompany(new CompanyDto(2L, "Company Test"));
		assertEquals("Company Test", this.companyService.findCompanyById(2L).getName());
	}
}
