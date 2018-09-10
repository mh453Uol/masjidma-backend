package com.mh453Uol.masjidma.restapi;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mh453Uol.masjidma.dtos.DailySalahDto;
import com.mh453Uol.masjidma.services.DailySalahService;

@RestController
@RequestMapping(value = "/salahs")
public class SalahController {

	@Autowired
	private DailySalahService dailySalahService;
	
	@RequestMapping(value="/{day}/{month}/{organisationId}", method = RequestMethod.GET)
	public DailySalahDto getSalahsByDate(@PathVariable Byte day,@PathVariable Byte month,
			@PathVariable Long organisationId) {
		
		return dailySalahService.findById(day,month,organisationId);
	}
	
	@RequestMapping(value = "/{numbericalMonth}", method = RequestMethod.POST)
	public ResponseEntity<DailySalahDto> addMonthlySalahs(@PathVariable @NotNull Integer numbericalMonth,
			@Valid @RequestBody ArrayList<DailySalahDto> salahs){
		
		if(salahs == null) {
			return null;
		}
		
		Month month = Month.of(numbericalMonth);
		
		if(salahs.size() > month.maxLength()) {
			return null;
		}
		
		this.dailySalahService.saveMontlySalahs(salahs);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
