package com.bnau.cdb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bnau.cdb.model.Company;

/**
 * Service to manage operations on companies.
 *
 * @author bertrand
 *
 */
public interface CompanyService {

	/**
	 * Find companies.
	 *
	 * @param pageable Pagination parameters.
	 *
	 * @return Page of companies.
	 */
	Page<Company> findCompanies(Pageable pageable);
}
