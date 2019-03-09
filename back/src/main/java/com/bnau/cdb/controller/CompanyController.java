package com.bnau.cdb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnau.cdb.dto.CompanyDto;
import com.bnau.cdb.service.CompanyService;
import com.bnau.cdb.swagger.ApiPageable;
import com.bnau.cdb.util.MapperUtil;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Controller for operations on company.
 *
 * @author bertrand
 *
 */
@RestController
@RequestMapping("api/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private MapperUtil mapperUtil;
	
	@ApiPageable
	@GetMapping
	public Page<CompanyDto> findCompanies(@ApiIgnore final Pageable pageable) {
		return mapperUtil.map(companyService.findCompanies(pageable), CompanyDto.class);
	}
	
	@GetMapping("/{id}")
	public CompanyDto findCompanyById(@PathVariable final Long id) {
		return mapperUtil.map(companyService.findCompanyById(id), CompanyDto.class);
	}
	
	@PostMapping
	public void updateCompany(@RequestBody @Valid final CompanyDto company) {
		companyService.updateCompany(company);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable final Long id) {
		companyService.deleteCompany(id);
	}
	
	@PutMapping
	public Long addCompany(@RequestBody final CompanyDto company) {
		return companyService.addCompany(company).getId();
	}
}
