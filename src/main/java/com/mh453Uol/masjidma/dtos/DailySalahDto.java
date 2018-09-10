package com.mh453Uol.masjidma.dtos;

import java.sql.Time;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DailySalahDto {
	
	@Size(min=1,max=31)
    private byte day;
 
	@Size(min=1,max=12)
    private byte month;
    
	@NotNull
    private long organisationId;
	
	@NotNull
	private Time sunrise;
	
	@NotNull
	private Time fajr;
	
	@NotNull
	private Time zuhr;
	
	@NotNull
	private Time asr;
	
	@NotNull
	private Time magrib;
	
	@NotNull
	private Time isha;

	public byte getDay() {
		return day;
	}

	public void setDay(byte day) {
		this.day = day;
	}

	public byte getMonth() {
		return month;
	}

	public void setMonth(byte month) {
		this.month = month;
	}

	public long getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(long organisationId) {
		this.organisationId = organisationId;
	}

	public Time getSunrise() {
		return sunrise;
	}

	public void setSunrise(Time sunrise) {
		this.sunrise = sunrise;
	}

	public Time getFajr() {
		return fajr;
	}

	public void setFajr(Time fajr) {
		this.fajr = fajr;
	}

	public Time getZuhr() {
		return zuhr;
	}

	public void setZuhr(Time zuhr) {
		this.zuhr = zuhr;
	}

	public Time getAsr() {
		return asr;
	}

	public void setAsr(Time asr) {
		this.asr = asr;
	}

	public Time getMagrib() {
		return magrib;
	}

	public void setMagrib(Time magrib) {
		this.magrib = magrib;
	}

	public Time getIsha() {
		return isha;
	}

	public void setIsha(Time isha) {
		this.isha = isha;
	}   
}
