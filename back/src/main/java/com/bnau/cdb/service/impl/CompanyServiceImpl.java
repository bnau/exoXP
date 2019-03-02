package com.bnau.cdb.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bnau.cdb.model.Company;
import com.bnau.cdb.service.CompanyService;

/**
 * Default implementation of {@link CompanyService}
 *
 * @author bertrand
 *
 */
@Service
public class CompanyServiceImpl implements CompanyService {

	/**
	 * {@inheritDocs}
	 */
	@Override
	public Page<Company> findCompanies(final Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
