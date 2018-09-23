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
	private JamaatPrayerTimeDto jammatTimes;

	@NotNull
	@Valid
	private PrayerStartTimeDto startPrayerTimes;

	public MasjidPrayerTimeDto() {
		this.jammatTimes = new JamaatPrayerTimeDto();
		this.startPrayerTimes = new PrayerStartTimeDto();
	}

	public MasjidPrayerTimeDto(int day, Month month, long organisationId, JamaatPrayerTimeDto jamaat,
			PrayerStartTimeDto startTimes) {
		this.day = day;
		this.month = month;
		this.organisationId = organisationId;
		this.jammatTimes = jamaat;
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

	public JamaatPrayerTimeDto getJammatTimes() {
		return jammatTimes;
	}

	public void setJammatTimes(JamaatPrayerTimeDto jammatTimes) {
		this.jammatTimes = jammatTimes;
	}
	public PrayerStartTimeDto getStartPrayerTimes() {
		return startPrayerTimes;
	}

	public void setStartPrayerTimes(PrayerStartTimeDto startPrayerTimes) {
		this.startPrayerTimes = startPrayerTimes;
	}
}
