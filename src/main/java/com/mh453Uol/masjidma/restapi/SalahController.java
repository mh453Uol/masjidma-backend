package com.mh453Uol.masjidma.restapi;

import java.time.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mh453Uol.masjidma.dtos.DailySalahDto;
import com.mh453Uol.masjidma.dtos.MonthlySalahDto;
import com.mh453Uol.masjidma.services.DailySalahService;

@RestController
@RequestMapping(value = "/salahs")
public class SalahController {

	@Autowired
	private DailySalahService dailySalahService;
	
	@RequestMapping(value="/{day}/{month}/{organisationId}", method = RequestMethod.GET)
	public DailySalahDto getSalahsByDate(@PathVariable int day,@PathVariable Month month,
			@PathVariable Long organisationId) {
		
		return dailySalahService.findById(day,month,organisationId);
	}
	
	@RequestMapping(value = "/{numbericalMonth}", method = RequestMethod.POST)
	public ResponseEntity<MonthlySalahDto> addMonthlySalahs(@PathVariable int numbericalMonth,
			@RequestBody MonthlySalahDto dto){
		
		if(dto == null) {
			return null;
		}
		
		
		if(dto.getSalahs().size() < dto.getMonth().minLength()) {
			//return null;
		}
		
		//this.dailySalahService.saveMontlySalahs(salahs);
		
		return new ResponseEntity<MonthlySalahDto>(dto,HttpStatus.CREATED);
	}
}
