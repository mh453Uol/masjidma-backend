package com.mh453Uol.masjidma.dtos;

import java.time.Month;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DailySalahDto extends SalahDto {
	
	@Size(min=1,max=31)
    private int day;
	
	@NotNull
    private Month month;
    
	@NotNull
    private long organisationId;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(long organisationId) {
		this.organisationId = organisationId;
	}
}
