package com.mh453Uol.masjidma.entities;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class JamaatPrayerTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Time jamaatFajr;

	@NotNull
	private Time jamaatZuhr;

	@NotNull
	private Time jamaatAsr;

	@NotNull
	private Time jamaatMagrib;

	@NotNull
	private Time jamaatIsha;

	public JamaatPrayerTime() {}
	
	public JamaatPrayerTime(Time fajr, Time zuhr, Time asr, Time magrib, Time isha) {
		super();
		this.jamaatFajr = fajr;
		this.jamaatZuhr = zuhr;
		this.jamaatAsr = asr;
		this.jamaatMagrib = magrib;
		this.jamaatIsha = isha;
	}

	public Time getJamaatFajr() {
		return jamaatFajr;
	}

	public void setJamaatFajr(Time jamaatFajr) {
		this.jamaatFajr = jamaatFajr;
	}

	public Time getJamaatZuhr() {
		return jamaatZuhr;
	}

	public void setJamaatZuhr(Time jamaatZuhr) {
		this.jamaatZuhr = jamaatZuhr;
	}

	public Time getJamaatAsr() {
		return jamaatAsr;
	}

	public void setJamaatAsr(Time jamaatAsr) {
		this.jamaatAsr = jamaatAsr;
	}

	public Time getJamaatMagrib() {
		return jamaatMagrib;
	}

	public void setJamaatMagrib(Time jamaatMagrib) {
		this.jamaatMagrib = jamaatMagrib;
	}

	public Time getJamaatIsha() {
		return jamaatIsha;
	}

	public void setJamaatIsha(Time jamaatIsha) {
		this.jamaatIsha = jamaatIsha;
	}
}
