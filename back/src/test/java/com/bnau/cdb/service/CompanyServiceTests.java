package com.bnau.cdb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnau.cdb.CdbApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
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
}
