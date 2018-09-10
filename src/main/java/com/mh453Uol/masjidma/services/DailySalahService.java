package com.mh453Uol.masjidma.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mh453Uol.masjidma.dtos.DailySalahDto;
import com.mh453Uol.masjidma.entities.DailySalah;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.SalahId;
import com.mh453Uol.masjidma.exceptions.NotFoundException;
import com.mh453Uol.masjidma.repositories.DailySalahRespository;

@Service
public class DailySalahService {

	@Autowired
	private DailySalahRespository dailySalahRepo;

	public List<DailySalah> getAllDailySalahs() {
		List<DailySalah> salahs = new ArrayList<DailySalah>();
		dailySalahRepo.findAll().forEach(salahs::add);
		return salahs;
	}

	public DailySalahDto findById(byte day, byte month, long organisationId) {
		Optional<DailySalah> salah = dailySalahRepo.findById(new SalahId(day, month, new Organisation(organisationId)));

		if (!salah.isPresent()) {
			throw new NotFoundException("Cant find salah");
		}

		DailySalahDto dto = new DailySalahDto();

		dto.setOrganisationId(salah.get().getSalahId().getOrganisation().getId());
		dto.setDay(salah.get().getSalahId().getDay());
		dto.setMonth(salah.get().getSalahId().getMonth());

		dto.setFajr(salah.get().getSalah().getFajr());
		dto.setSunrise(salah.get().getSalah().getSunrise());
		dto.setZuhr(salah.get().getSalah().getZuhr());
		dto.setAsr(salah.get().getSalah().getAsr());
		dto.setMagrib(salah.get().getSalah().getMagrib());
		dto.setIsha(salah.get().getSalah().getIsha());

		return dto;
	}

	public void saveMontlySalahs(@Valid ArrayList<DailySalahDto> salahs) {
		ArrayList<DailySalah> monthlySalah = new ArrayList<DailySalah>();

		for (DailySalahDto dailySalahDto : salahs) {

			monthlySalah.add(new DailySalah(dailySalahDto.getDay(), dailySalahDto.getMonth(),
					new Organisation(dailySalahDto.getOrganisationId()), dailySalahDto.getFajr(),
					dailySalahDto.getSunrise(), dailySalahDto.getZuhr(), dailySalahDto.getAsr(),
					dailySalahDto.getMagrib(), dailySalahDto.getIsha()));
		}
		dailySalahRepo.saveAll(monthlySalah);
	}

}
