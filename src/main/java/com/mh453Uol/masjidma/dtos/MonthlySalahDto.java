package com.mh453Uol.masjidma.dtos;

import java.time.*;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class MonthlySalahDto {

	@NotNull
	private Month month;
	
	@NotNull
	private Long organisationId;

	@NotEmpty
	@Valid
	private ArrayList<MasjidPrayerTimeDto> salahs;

	public MonthlySalahDto() {
		this.salahs = new ArrayList<MasjidPrayerTimeDto>();
	}
	
	public MonthlySalahDto(Month month, long organisationId) {
		this();
		this.month = month;
		this.organisationId = organisationId;
	}

	public int getMonth() {
		return month.getValue();
	}

	public void setMonth(int month) {
		this.month = Month.of(month);
	}

	public ArrayList<MasjidPrayerTimeDto> getSalahs() {
		return salahs;
	}

	public void setSalahs(ArrayList<MasjidPrayerTimeDto> salahs) {
		this.salahs = salahs;
	}

	public Long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}
}
