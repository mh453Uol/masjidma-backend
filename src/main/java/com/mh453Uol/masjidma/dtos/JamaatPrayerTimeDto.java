package com.mh453Uol.masjidma.dtos;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class JamaatPrayerTimeDto {
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm") //format LocalTime as <1-24>:<0-59>
	private LocalTime fajr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime zuhr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime asr;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm") 
	private LocalTime magrib;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "kk:mm")
	private LocalTime isha;
	
	public JamaatPrayerTimeDto() {}
	
	public JamaatPrayerTimeDto(@NotNull LocalTime fajr, @NotNull LocalTime zuhr, @NotNull LocalTime asr,
			@NotNull LocalTime magrib, @NotNull LocalTime isha) {
		super();
		this.fajr = fajr;
		this.zuhr = zuhr;
		this.asr = asr;
		this.magrib = magrib;
		this.isha = isha;
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
