package com.mh453Uol.masjidma.dtos;

import java.time.Month;
import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MonthlySalahDto {
	
	@NotNull
	private Month month;
	
	@NotBlank
	private ArrayList<SalahDto> salahs;
	
	private MonthlySalahDto() {
		this.salahs = new ArrayList<SalahDto>();
	}
	
	public Month getMonth() {
		return month;
	}
	public void setMonth(Month month) {
		this.month = month;
	}
	public ArrayList<SalahDto> getSalahs() {
		return salahs;
	}
	public void setSalahs(ArrayList<SalahDto> salahs) {
		this.salahs = salahs;
	}
}
