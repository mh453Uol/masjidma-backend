package com.mh453Uol.masjidma.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PrayerStartTime implements Serializable {

	private static final long serialVersionUID = -8214078520075209476L;

	@NotNull
	private Time sunriseStartTime;

	@NotNull
	private Time fajrStartTime;

	@NotNull
	private Time zuhrStartTime;

	@NotNull
	private Time asrStartTime;

	@NotNull
	private Time ishaStartTime;

	public PrayerStartTime() {}
	
	//Magrib is prayed on the start time so we dont need to specify it here
	public PrayerStartTime(Time sunrise, Time fajr, Time zuhr, Time asr, Time isha) {
		super();
		this.sunriseStartTime = sunrise;
		this.fajrStartTime = fajr;
		this.zuhrStartTime = zuhr;
		this.asrStartTime = asr;
		this.ishaStartTime = isha;
	}

	public Time getSunriseStartTime() {
		return sunriseStartTime;
	}

	public void setSunriseStartTime(Time sunriseStartTime) {
		this.sunriseStartTime = sunriseStartTime;
	}

	public Time getFajrStartTime() {
		return fajrStartTime;
	}

	public void setFajrStartTime(Time fajrStartTime) {
		this.fajrStartTime = fajrStartTime;
	}

	public Time getZuhrStartTime() {
		return zuhrStartTime;
	}

	public void setZuhrStartTime(Time zuhrStartTime) {
		this.zuhrStartTime = zuhrStartTime;
	}

	public Time getAsrStartTime() {
		return asrStartTime;
	}

	public void setAsrStartTime(Time asrStartTime) {
		this.asrStartTime = asrStartTime;
	}

	public Time getIshaStartTime() {
		return ishaStartTime;
	}

	public void setIshaStartTime(Time ishaStartTime) {
		this.ishaStartTime = ishaStartTime;
	}
}
