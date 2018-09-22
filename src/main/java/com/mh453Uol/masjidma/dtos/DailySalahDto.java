package com.mh453Uol.masjidma.dtos;

import java.time.LocalTime;
import java.time.Month;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DailySalahDto extends SalahDto {
	
	@NotNull
	@Min(value = 1)
	@Max(value = 31)
	private int day;
	
	@NotNull
	private Month month;

	@NotNull
	private Long organisationId;
	
	public DailySalahDto() {}
	
	public DailySalahDto(int day, Month month, long organisationId, LocalTime sunrise, LocalTime fajr, LocalTime zuhr,
			LocalTime asr, LocalTime magrib, LocalTime isha) {
		
		super(sunrise,fajr,zuhr,asr,magrib,isha);
		this.day = day;
		this.month = month;
		this.organisationId = organisationId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month.getValue();
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
