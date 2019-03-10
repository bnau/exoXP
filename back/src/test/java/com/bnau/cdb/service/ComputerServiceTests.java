package com.bnau.cdb.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bnau.cdb.CdbApplication;
import com.bnau.cdb.dto.CompanyDto;
import com.bnau.cdb.dto.ComputerDto;
import com.bnau.cdb.model.Computer;
import com.bnau.cdb.repository.ComputerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CdbApplication.class)
@Transactional
public class ComputerServiceTests {
	
	@Autowired
	ComputerService computerService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	ComputerRepository computerRepository;
	
	@Test
	public void findComputersTest() {
		assertTrue(computerService.findComputers(PageRequest.of(2, 1)).getSize() > 0);
	}
	
	@Test
	public void findComputerByIdTest() {
		assertEquals("MacBook Pro 15.4 inch", computerService.findComputerById(1L).getName());
	}
	
	@Test
	public void updateComputerTest() {
		computerService.updateComputer(new ComputerDto(2L, "Computer Test", LocalDate.of(2000, Month.JANUARY, 1),
				LocalDate.of(2001, Month.JANUARY, 1), new CompanyDto(3L, "Useless name")));
		final Computer savedComputer = computerService.findComputerById(2L);
		assertEquals("Computer Test", savedComputer.getName());
		assertEquals(LocalDate.of(2000, Month.JANUARY, 1), savedComputer.getIntroduced());
		assertEquals(LocalDate.of(2001, Month.JANUARY, 1), savedComputer.getDiscontinued());
		assertEquals(companyService.findCompanyById(3L), savedComputer.getCompany());
	}
	
	@Test
	public void deleteComputerTest() {
		computerService.deleteComputer(1L);
		assertFalse(computerRepository.findById(1L).isPresent());
	}
	
	@Test
	public void addComputerTest() {
		final ComputerDto computerDto = new ComputerDto(null, "Computer Test", LocalDate.of(2000, Month.JANUARY, 1),
				LocalDate.of(2001, Month.JANUARY, 1), new CompanyDto(3L, "Useless name"));
		final Computer computer = computerService.addComputer(computerDto);
		assertNotNull(computer.getId());
		assertEquals(companyService.findCompanyById(3L), computer.getCompany());
	}
}
