package com.mh453Uol.masjidma.services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mh453Uol.masjidma.dtos.DailySalahDto;
import com.mh453Uol.masjidma.dtos.MonthlySalahDto;
import com.mh453Uol.masjidma.dtos.SalahDto;
import com.mh453Uol.masjidma.entities.DailySalah;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.Salah;
import com.mh453Uol.masjidma.entities.SalahId;
import com.mh453Uol.masjidma.entities.User;
import com.mh453Uol.masjidma.exceptions.NotFoundException;
import com.mh453Uol.masjidma.repositories.DailySalahRespository;
import com.mh453Uol.masjidma.utils.Time;

@Service
public class DailySalahService {

	@Autowired
	private DailySalahRespository dailySalahRepo;

	public List<DailySalah> getAllDailySalahs() {
		List<DailySalah> salahs = new ArrayList<DailySalah>();
		dailySalahRepo.findAll().forEach(salahs::add);
		return salahs;
	}

	public DailySalahDto findById(int day, Month month, long organisationId) {
		Optional<DailySalah> salah = dailySalahRepo
				.findById(new SalahId(day, month.getValue(), new Organisation(organisationId)));

		if (!salah.isPresent()) {
			throw new NotFoundException("Cant find salah");
		}

		DailySalahDto dto = new DailySalahDto();
		SalahId salahId = salah.get().getSalahId();
		Salah salahTimes = salah.get().getSalah();

		dto.setOrganisationId(salahId.getOrganisation().getId());
		dto.setDay(salahId.getDay());
		dto.setMonth(Month.of(salahId.getMonth()));

		dto.setFajr(salahTimes.getFajr().toLocalTime());
		dto.setSunrise(salahTimes.getSunrise().toLocalTime());
		dto.setZuhr(salahTimes.getZuhr().toLocalTime());
		dto.setAsr(salahTimes.getAsr().toLocalTime());
		dto.setMagrib(salahTimes.getMagrib().toLocalTime());
		dto.setIsha(salahTimes.getIsha().toLocalTime());

		return dto;
	}

	public void saveMontlySalahs(MonthlySalahDto dto) {
		ArrayList<DailySalah> monthlySalah = new ArrayList<DailySalah>();
		DailySalah salaht = null;
		
		for (DailySalahDto salah : dto.getSalahs()) {
			salaht = new DailySalah(salah.getDay(), dto.getMonth(),
					new Organisation(dto.getOrganisationId()), Time.toSqlTime(salah.getFajr()),
					Time.toSqlTime(salah.getSunrise()), Time.toSqlTime(salah.getZuhr()), Time.toSqlTime(salah.getAsr()),
					Time.toSqlTime(salah.getMagrib()), Time.toSqlTime(salah.getIsha()));
			
			salaht.getAudit().create(new User(1L));
			
			//hibernate by default does a select to see if the record already exists if it does then it issues a UPDATE or INSERT
			monthlySalah.add(salaht);
		}
		
		dailySalahRepo.saveAll(monthlySalah);
	}
	
	public MonthlySalahDto getMonthlySalahs(Month month, long organisationId){		
		Iterable<DailySalah> salahs = this.dailySalahRepo.
				findBySalahIdMonthAndSalahIdOrganisation(month.getValue(), new Organisation(organisationId));
		
		MonthlySalahDto dto = new MonthlySalahDto(month, organisationId);
		
		for(DailySalah salah: salahs) {
			dto.getSalahs().add(new DailySalahDto(
					salah.getSalahId().getDay(),
					Month.of(salah.getSalahId().getMonth()),
					salah.getSalahId().getOrganisation().getId().longValue(),
					salah.getSalah().getFajr().toLocalTime(),
					salah.getSalah().getSunrise().toLocalTime(),
					salah.getSalah().getZuhr().toLocalTime(),
					salah.getSalah().getAsr().toLocalTime(),
					salah.getSalah().getMagrib().toLocalTime(),
					salah.getSalah().getIsha().toLocalTime()));
		}
		
		return dto;
	}
}
