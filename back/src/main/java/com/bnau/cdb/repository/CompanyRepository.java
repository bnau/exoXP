package com.bnau.cdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnau.cdb.model.Company;

/**
 * Repository for companies.
 *
 * @author bertrand
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	
}
