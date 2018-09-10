package com.mh453Uol.masjidma.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long userId;
	
	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;
	
	@JoinColumn(name="organisation_id")
	@ManyToOne(fetch=FetchType.LAZY)
	private Organisation organisation;
	
	@Embedded
	private Audit audit;
	
	public User() {
		this.audit = new Audit();
	};
	
	public User(Long id) {
		this();
		this.userId = id;
	}
	
	public User(String firstname, String lastname) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Organisation getOrganisation() {
		return organisation;
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public Audit getAudit() {
		return audit;
	}
	public void setAudit(Audit audit) {
		this.audit = audit;
	}
}
