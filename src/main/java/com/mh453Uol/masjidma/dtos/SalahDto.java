package com.mh453Uol.masjidma.dtos;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

public class SalahDto {
	
	@NotNull
	private LocalTime sunrise;
	
	@NotNull
	private LocalTime fajr;
	
	@NotNull
	private LocalTime zuhr;
	
	@NotNull
	private LocalTime asr;
	
	@NotNull
	private LocalTime magrib;
	
	@NotNull
	private LocalTime isha;

	public LocalTime getSunrise() {
		return sunrise;
	}

	public void setSunrise(LocalTime sunrise) {
		this.sunrise = sunrise;
	}

	public LocalTime getFajr() {
		return fajr;
	}

	public void setFajr(LocalTime fajr) {
		this.fajr = fajr;
	}

	public LocalTime getZuhr() {
		return zuhr;
	}

	public void setZuhr(LocalTime zuhr) {
		this.zuhr = zuhr;
	}

	public LocalTime getAsr() {
		return asr;
	}

	public void setAsr(LocalTime asr) {
		this.asr = asr;
	}

	public LocalTime getMagrib() {
		return magrib;
	}

	public void setMagrib(LocalTime magrib) {
		this.magrib = magrib;
	}

	public LocalTime getIsha() {
		return isha;
	}

	public void setIsha(LocalTime isha) {
		this.isha = isha;
	}
}
