package com.bnau.cdb.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bnau.cdb.dto.CompanyDto;
import com.bnau.cdb.model.Company;
import com.bnau.cdb.repository.CompanyRepository;
import com.bnau.cdb.service.CompanyService;

/**
 * Default implementation of {@link CompanyService}
 *
 * @author bertrand
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public Page<Company> findCompanies(final Pageable pageable) {
		return this.companyRepository.findAll(pageable);
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public Company findCompanyById(final Long id) {
		try {
			return this.companyRepository.findById(id).get();
		} catch (final NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company Not Found", e);
		}
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public void updateCompany(final CompanyDto company) {
		// TODO Auto-generated method stub

	}

}
