package com.bnau.cdb.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bnau.cdb.dto.CompanyDto;
import com.bnau.cdb.model.Company;
import com.bnau.cdb.repository.CompanyRepository;
import com.bnau.cdb.repository.ComputerRepository;
import com.bnau.cdb.service.CompanyService;
import com.bnau.cdb.util.MapperUtil;

/**
 * Default implementation of {@link CompanyService}
 *
 * @author bertrand
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private MapperUtil mapperUtil;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ComputerRepository computerRepository;

	/**
	 * {@inheritDocs}
	 */
	@Override
	public Page<Company> findCompanies(final Pageable pageable) {
		final PageRequest page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
				pageable.getSortOr(Sort.by("id")));
		return companyRepository.findAll(page);
	}

	/**
	 * {@inheritDocs}
	 */
	@Override
	public Company findCompanyById(final Long id) {
		try {
			return companyRepository.findById(id).get();
		} catch (final NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Company Not Found", e);
		}
	}

	/**
	 * {@inheritDocs}
	 */
	@Override
	public void updateCompany(final CompanyDto company) {
		final Company dbCompany = findCompanyById(company.getId());
		dbCompany.setName(company.getName());
		companyRepository.save(dbCompany);
	}

	/**
	 * {@inheritDocs}
	 */
	@Override
	public void deleteCompany(final Long id) {
		computerRepository.deleteByCompany(findCompanyById(id));
		companyRepository.deleteById(id);
	}

	/**
	 * {@inheritDocs}
	 */
	@Override
	public Company addCompany(final CompanyDto company) {
		final Company dbCompany = mapperUtil.map(company, Company.class);
		return companyRepository.save(dbCompany);
	}

}
