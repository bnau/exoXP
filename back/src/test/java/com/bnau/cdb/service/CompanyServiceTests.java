package com.bnau.cdb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
import com.bnau.cdb.model.Company;
import com.bnau.cdb.repository.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@Transactional
public class CompanyServiceTests {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Test
	public void findCompaniesTest() {
		assertTrue(companyService.findCompanies(PageRequest.of(2, 1)).getSize() > 0);
	}
	
	@Test
	public void findCompanyByIdTest() {
		assertEquals("Apple Inc.", companyService.findCompanyById(1L).getName());
	}
	
	@Test
	public void updateCompanyTest() {
		companyService.updateCompany(new CompanyDto(2L, "Company Test"));
		assertEquals("Company Test", companyService.findCompanyById(2L).getName());
	}
	
	@Test
	public void deleteCompanyTest() {
		companyService.deleteCompany(1L);
		assertFalse(companyRepository.findById(1L).isPresent());
	}
	
	@Test
	public void addCompanyTest() {
		final CompanyDto companyDto = new CompanyDto();
		companyDto.setName("Test Name");
		final Company company = companyService.addCompany(companyDto);
		assertNotNull(company.getId());
	}
}
