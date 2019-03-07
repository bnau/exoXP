package com.bnau.cdb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bnau.cdb.dto.CompanyDto;
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

	/**
	 * Find the company by its id.
	 *
	 * @param id The id of the company.
	 * @return The Company
	 */
	Company findCompanyById(Long id);

	/**
	 * Update the company.
	 *
	 * @param company The company informations.
	 */
	void updateCompany(CompanyDto company);

	/**
	 * Delete a company.
	 *
	 * @param id The id of the company to delete.
	 */
	void deleteCompany(Long id);

	/**
	 * Insert a company.
	 *
	 * @param company The company to insert.
	 */
	Company addCompany(CompanyDto company);
}
