package com.bnau.cdb.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity class for computer.
 *
 * @author bertrand
 *
 */
@Entity
@Table(name = "computer")
public class Computer implements Serializable {

	private static final long serialVersionUID = 8960295030845081664L;

	private Long id;
	private String name;
	private LocalDate introduced;
	private LocalDate discontinued;
	private Company company;
	
	/**
	 * @return the id
	 */
	@SequenceGenerator(name = "ComputerGenerator", sequenceName = "seq_computer", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ComputerGenerator")
	@Column(name = "id")
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
	@Column(name = "name")
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
	@Column(name = "introduced")
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
	@Column(name = "discontinued")
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}
	
	/**
	 * @param company the company to set
	 */
	public void setCompany(final Company company) {
		this.company = company;
	}
}
