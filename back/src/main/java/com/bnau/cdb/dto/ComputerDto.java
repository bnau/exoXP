package com.bnau.cdb.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.bnau.cdb.dto.validator.DateAnterior;

@DateAnterior
public class ComputerDto {
	
	private Long id;
	@NotNull
	@NotBlank
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	private CompanyDto company;

	public ComputerDto() {
	}
	
	public ComputerDto(final Long id, @NotNull @NotBlank final String name, final LocalDate introduced,
			final LocalDate discontinued, final CompanyDto company) {
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
	
	/**
	 * @return the introduced
	 */
	public LocalDate getIntroduced() {
		return introduced;
	}
	
	/**
	 * @param introduced the introduced to set
	 */
	public void setIntroduced(final LocalDate introduced) {
		this.introduced = introduced;
	}
	
	/**
	 * @return the discontinued
	 */
	public LocalDate getDiscontinued() {
		return discontinued;
	}
	
	/**
	 * @param discontinued the discontinued to set
	 */
	public void setDiscontinued(final LocalDate discontinued) {
		this.discontinued = discontinued;
	}
	
	/**
	 * @return the company
	 */
	public CompanyDto getCompany() {
		return company;
	}
	
	/**
	 * @param company the company to set
	 */
	public void setCompany(final CompanyDto company) {
		this.company = company;
	}
}
