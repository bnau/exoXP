package com.bnau.cdb.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bnau.cdb.dto.ComputerDto;
import com.bnau.cdb.model.Computer;

/**
 * Service to manage operations on computers.
 *
 * @author bertrand
 *
 */
public interface ComputerService {

	/**
	 * Find computers.
	 *
	 * @param pageable Pagination parameters.
	 *
	 * @return Page of computers.
	 */
	Page<Computer> findComputers(Pageable pageable);

	/**
	 * Find the computer by its id.
	 *
	 * @param id The id of the computer.
	 * @return The Computer
	 */
	Computer findComputerById(Long id);

	/**
	 * Update the computer.
	 *
	 * @param computer The computer informations.
	 */
	void updateComputer(ComputerDto computer);

	/**
	 * Delete a computer.
	 *
	 * @param id The id of the computer to delete.
	 */
	void deleteComputer(Long id);

	/**
	 * Insert a computer.
	 *
	 * @param computer The computer to insert.
	 */
	Computer addComputer(ComputerDto computer);
}
