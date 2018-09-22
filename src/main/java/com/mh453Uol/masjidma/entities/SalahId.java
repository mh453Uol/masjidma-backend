package com.mh453Uol.masjidma.entities;

import java.io.Serializable;
import java.time.Month;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class SalahId implements Serializable {

	private static final long serialVersionUID = -8344220517298509794L;

	@Column(name = "day")
	@Min(value = 1)
	@Max(value = 31)
	private int day;

	@Column(name = "month")
	@Min(value = 1)
	@Max(value = 12)
	private int month;

	@ManyToOne(fetch = FetchType.LAZY) // organisation can have many salah events and salah is for one organisation
	@JoinColumn(name = "organisation_id")
	private Organisation organisation;

	public SalahId() {
	}

	public SalahId(int day, int month, Organisation organisation) {
		this.day = day;
		this.month = month;
		this.organisation = organisation;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public void setOrganisation(Organisation organisation) {
		this.organisation = organisation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof SalahId))
			return false;
		SalahId that = (SalahId) o;
		return Objects.equals(getDay(), that.getDay()) && Objects.equals(getMonth(), that.getMonth())
				&& Objects.equals(getOrganisation(), that.getOrganisation());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDay(), getMonth(), getOrganisation());
	}
}