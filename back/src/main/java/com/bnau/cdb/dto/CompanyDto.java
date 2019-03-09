package com.bnau.cdb.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanyDto {
	
	private Long id;
	@NotNull
	@NotBlank
	private String name;
	
	public CompanyDto() {
	}
	
	public CompanyDto(final Long id, final String name) {
		this.id = id;
		this.name = name;
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
}
