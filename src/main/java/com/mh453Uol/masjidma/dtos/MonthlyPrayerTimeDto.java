package com.mh453Uol.masjidma.dtos;

import java.time.*;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MonthlyPrayerTimeDto {

	@NotNull
	private Month month;
	
	@NotNull
	private Long organisationId;

	@NotEmpty
	@Valid
	private ArrayList<MasjidPrayerTimeDto> prayerTimes;

	public MonthlyPrayerTimeDto() {
		this.prayerTimes = new ArrayList<MasjidPrayerTimeDto>();
	}
	
	public MonthlyPrayerTimeDto(Month month, long organisationId) {
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

	public ArrayList<MasjidPrayerTimeDto> getPrayerTimes() {
		return prayerTimes;
	}

	public void setPrayerTimes(ArrayList<MasjidPrayerTimeDto> salahs) {
		this.prayerTimes = salahs;
	}

	public Long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}
}
