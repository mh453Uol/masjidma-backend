package com.mh453Uol.masjidma.entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nondailysalah")
public class NonDailySalah {
	
	@Id
	@Column(name = "non_daily_salah_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    @JoinColumn(name="organisation_id")
	@ManyToOne
	private Organisation organisation;
	
	@NotNull
	private String name;
	
	@NotNull
	private Time time;
	
	@Column(name = "show_from")
	@NotNull
	private Date showFrom;
	
	@Column(name = "show_to")
	@NotNull
	private Date showTo;
	
	@Embedded
	private Audit audit;
	
	public NonDailySalah() {}
	
	public NonDailySalah(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Organisation getOrganisation() {
		return organisation;
	}
	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getShowFrom() {
		return showFrom;
	}
	public void setShowFrom(Date showFrom) {
		this.showFrom = showFrom;
	}
	public Date getShowTo() {
		return showTo;
	}
	public void setShowTo(Date showTo) {
		this.showTo = showTo;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}
	
}
