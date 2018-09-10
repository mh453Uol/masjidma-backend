package com.mh453Uol.masjidma.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Salah implements Serializable {

	private static final long serialVersionUID = -8214078520075209476L;

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
