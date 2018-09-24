package com.mh453Uol.masjidma.dtos;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrayerStartTimeDto {

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm") //format LocalTime as <1-24>:<0-59>
	private LocalTime sunrise;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime fajr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime zuhr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime asr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime isha;
	
	public PrayerStartTimeDto() {}
	
	public PrayerStartTimeDto(LocalTime sunrise, LocalTime fajr, LocalTime zuhr,
			LocalTime asr,  LocalTime isha) {
		super();
		this.sunrise = sunrise;
		this.fajr = fajr;
		this.zuhr = zuhr;
		this.asr = asr;
		this.isha = isha;
	}

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

	public LocalTime getIsha() {
		return isha;
	}

	public void setIsha(LocalTime isha) {
		this.isha = isha;
	}
}
