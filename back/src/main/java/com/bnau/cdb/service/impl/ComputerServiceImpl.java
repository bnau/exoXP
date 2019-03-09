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

import com.bnau.cdb.dto.ComputerDto;
import com.bnau.cdb.model.Computer;
import com.bnau.cdb.repository.ComputerRepository;
import com.bnau.cdb.service.CompanyService;
import com.bnau.cdb.service.ComputerService;

/**
 * Default implementation of {@link ComputerService}
 *
 * @author bertrand
 *
 */
@Service
public class ComputerServiceImpl implements ComputerService {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private ComputerRepository computerRepository;
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public Page<Computer> findComputers(final Pageable pageable) {
		final PageRequest page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
				pageable.getSortOr(Sort.by("id")));
		return computerRepository.findAll(page);
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public Computer findComputerById(final Long id) {
		try {
			return computerRepository.findById(id).get();
		} catch (final NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Computer Not Found", e);
		}
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public void updateComputer(final ComputerDto computer) {
		final Computer dbComputer = findComputerById(computer.getId());
		populateComputerData(computer, dbComputer);
		computerRepository.save(dbComputer);
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public void deleteComputer(final Long id) {
		computerRepository.deleteById(id);
	}
	
	/**
	 * {@inheritDocs}
	 */
	@Override
	public Computer addComputer(final ComputerDto computer) {
		final Computer dbComputer = new Computer();
		populateComputerData(computer, dbComputer);
		return computerRepository.save(dbComputer);
	}
	
	private void populateComputerData(final ComputerDto computer, final Computer dbComputer) {
		dbComputer.setName(computer.getName());
		dbComputer.setIntroduced(computer.getIntroduced());
		dbComputer.setDiscontinued(computer.getDiscontinued());
		dbComputer.setCompany(companyService.findCompanyById(computer.getCompany().getId()));
	}

}
