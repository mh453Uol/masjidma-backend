package com.mh453Uol.masjidma.dtos;

import java.time.Month;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MasjidPrayerTimeDto {

	@NotNull
	@Min(value = 1)
	@Max(value = 31)
	private int day;

	@NotNull
	private Month month;

	@NotNull
	private Long organisationId;

	@NotNull
	@Valid
	private JamaatPrayerTimeDto jamaatTimes;

	@NotNull
	@Valid
	private PrayerStartTimeDto startPrayerTimes;

	public MasjidPrayerTimeDto() {
		this.jamaatTimes = new JamaatPrayerTimeDto();
		this.startPrayerTimes = new PrayerStartTimeDto();
	}

	public MasjidPrayerTimeDto(int day, Month month, long organisationId,PrayerStartTimeDto startTimes,
			JamaatPrayerTimeDto jamaat) {
		this.day = day;
		this.month = month;
		this.organisationId = organisationId;
		this.jamaatTimes = jamaat;
		this.startPrayerTimes = startTimes;
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

	public void setOrganisationId(Long organisationId) {
		this.organisationId = organisationId;
	}

	public JamaatPrayerTimeDto getJamaatTimes() {
		return jamaatTimes;
	}

	public void setJamaatTimes(JamaatPrayerTimeDto jammatTimes) {
		this.jamaatTimes = jammatTimes;
	}
	public PrayerStartTimeDto getStartPrayerTimes() {
		return startPrayerTimes;
	}

	public void setStartPrayerTimes(PrayerStartTimeDto startPrayerTimes) {
		this.startPrayerTimes = startPrayerTimes;
	}
}
