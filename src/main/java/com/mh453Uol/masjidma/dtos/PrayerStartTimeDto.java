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
	
	public PrayerStartTimeDto(@NotNull LocalTime sunrise, @NotNull LocalTime fajr, @NotNull LocalTime zuhr,
			@NotNull LocalTime asr, @NotNull LocalTime isha) {
		super();
		this.sunrise = sunrise;
		this.fajr = fajr;
		this.zuhr = zuhr;
		this.asr = asr;
		this.isha = isha;
	}
}
