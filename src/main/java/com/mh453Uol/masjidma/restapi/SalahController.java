package com.mh453Uol.masjidma.restapi;

import java.time.Month;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mh453Uol.masjidma.dtos.MasjidPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.MonthlyPrayerTimeDto;
import com.mh453Uol.masjidma.services.DailySalahService;

@RestController
@RequestMapping(value = "/salahs")
public class SalahController {

	@Autowired
	private DailySalahService dailySalahService;

	@RequestMapping(value = "/{day}/{month}/{organisationId}", method = RequestMethod.GET)
	public MasjidPrayerTimeDto getSalahsByDate(@PathVariable int day, @PathVariable int month,
			@PathVariable long organisationId) {
		return dailySalahService.findById(day, Month.of(month), organisationId);
	}

	@RequestMapping(value = "/monthly", method = RequestMethod.POST)
	public ResponseEntity<MonthlyPrayerTimeDto> addMonthlySalahs(@RequestBody @Valid MonthlyPrayerTimeDto dto) {
		
		this.dailySalahService.saveMontlySalahs(dto);

		return new ResponseEntity<MonthlyPrayerTimeDto>(dto,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/monthly/{month}/{organisationId}", method = RequestMethod.GET)
	public ResponseEntity<MonthlyPrayerTimeDto> getMonthlySalahs(@PathVariable int month,
			@PathVariable long organisationId){
		
		MonthlyPrayerTimeDto salahs = this.dailySalahService.getMonthlySalahs(Month.of(month), organisationId);
		
		return new ResponseEntity<MonthlyPrayerTimeDto>(salahs,HttpStatus.OK);
	}
}
