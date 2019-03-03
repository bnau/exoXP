package com.bnau.cdb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class for company.
 *
 * @author bertrand
 *
 */
@Entity
@Table(name="company")
public class Company implements Serializable {

	private static final long serialVersionUID = 6825864928192684164L;
	
	private Long id;
	private String name;
	private Set<Computer> computers = new HashSet<>();
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="id")
	public Long getId() {
		return this.id;
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
	@Column(name="name")
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
	

	/**
	 * @return the computers
	 */
	@OneToMany(fetch=FetchType.LAZY, mappedBy="company")
	public Set<Computer> getComputers() {
		return this.computers;
	}
	
	/**
	 * @param computers the computers to set
	 */
	public void setComputers(final Set<Computer> computers) {
		this.computers = computers;
	}
}