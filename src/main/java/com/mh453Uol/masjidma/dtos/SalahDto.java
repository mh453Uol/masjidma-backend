package com.mh453Uol.masjidma.dtos;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalahDto {

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m") //format LocalTime as <1-24>:<0-59>
	private LocalTime sunrise;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m")
	private LocalTime fajr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m")
	private LocalTime zuhr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m")
	private LocalTime asr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m")
	private LocalTime magrib;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "k:m")
	private LocalTime isha;
	
	public SalahDto() {}
	
	public SalahDto(LocalTime sunrise, LocalTime fajr, LocalTime zuhr,
			LocalTime asr, LocalTime magrib, LocalTime isha) {
		super();
		this.sunrise = sunrise;
		this.fajr = fajr;
		this.zuhr = zuhr;
		this.asr = asr;
		this.magrib = magrib;
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
