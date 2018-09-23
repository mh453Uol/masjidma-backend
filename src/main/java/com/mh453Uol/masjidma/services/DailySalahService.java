package com.mh453Uol.masjidma.services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mh453Uol.masjidma.dtos.JamaatPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.MasjidPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.MonthlySalahDto;
import com.mh453Uol.masjidma.dtos.PrayerStartTimeDto;
import com.mh453Uol.masjidma.entities.JamaatPrayerTime;
import com.mh453Uol.masjidma.entities.MasjidPrayerTime;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.PrayerId;
import com.mh453Uol.masjidma.entities.PrayerStartTime;
import com.mh453Uol.masjidma.exceptions.NotFoundException;
import com.mh453Uol.masjidma.repositories.DailySalahRespository;

@Service
public class DailySalahService {

	@Autowired
	private DailySalahRespository dailySalahRepo;

	public List<MasjidPrayerTime> getAllDailySalahs() {
		List<MasjidPrayerTime> salahs = new ArrayList<MasjidPrayerTime>();
		dailySalahRepo.findAll().forEach(salahs::add);
		return salahs;
	}

	public MasjidPrayerTimeDto findById(int day, Month month, long organisationId) {
		Optional<MasjidPrayerTime> salah = dailySalahRepo
				.findById(new PrayerId(day, month.getValue(), new Organisation(organisationId)));

		if (!salah.isPresent()) {
			throw new NotFoundException("Cant find salah");
		}

		MasjidPrayerTimeDto dto = new MasjidPrayerTimeDto();
		PrayerId salahId = salah.get().getSalahId();
		JamaatPrayerTime jamaatTimes = salah.get().getJammatTimes();
		PrayerStartTime startTimes = salah.get().getSalahStartTimes();

		dto.setOrganisationId(salahId.getOrganisation().getId());
		dto.setDay(salahId.getDay());
		dto.setMonth(Month.of(salahId.getMonth()));

		dto.setJammatTimes(new JamaatPrayerTimeDto(
				jamaatTimes.getJamaatFajr().toLocalTime(),
				jamaatTimes.getJamaatZuhr().toLocalTime(), 
				jamaatTimes.getJamaatAsr().toLocalTime(),
				jamaatTimes.getJamaatMagrib().toLocalTime(), 
				jamaatTimes.getJamaatIsha().toLocalTime()));
		
		dto.setStartPrayerTimes(new PrayerStartTimeDto(
				startTimes.getFajrStartTime().toLocalTime(),
				startTimes.getSunriseStartTime().toLocalTime(),
				startTimes.getZuhrStartTime().toLocalTime(),
				startTimes.getAsrStartTime().toLocalTime(),
				startTimes.getIshaStartTime().toLocalTime()));

		return dto;
	}

	public void saveMontlySalahs(MonthlySalahDto dto) {
		ArrayList<MasjidPrayerTime> monthlySalah = new ArrayList<MasjidPrayerTime>();
		MasjidPrayerTime salaht = null;

		// for (DailySalahDto salah : dto.getSalahs()) {
		// salaht = new MasjidPrayerTimes(salah.getDay(), dto.getMonth(),
		// new Organisation(dto.getOrganisationId()), Time.toSqlTime(salah.getFajr()),
		// Time.toSqlTime(salah.getSunrise()), Time.toSqlTime(salah.getZuhr()),
		// Time.toSqlTime(salah.getAsr()),
		// Time.toSqlTime(salah.getMagrib()), Time.toSqlTime(salah.getIsha()));
		//
		// salaht.getAudit().create(new User(1L));
		//
		// //hibernate by default does a select to see if the record already exists if
		// it does then it issues a UPDATE or INSERT
		// monthlySalah.add(salaht);
		// }

		// dailySalahRepo.saveAll(monthlySalah);
	}

	public MonthlySalahDto getMonthlySalahs(Month month, long organisationId) {
		Iterable<MasjidPrayerTime> salahs = this.dailySalahRepo
				.findBySalahIdMonthAndSalahIdOrganisation(month.getValue(), new Organisation(organisationId));

		MonthlySalahDto dto = new MonthlySalahDto(month, organisationId);

		// for(MasjidPrayerTimes salah: salahs) {
		// dto.getSalahs().add(new DailySalahDto(
		// salah.getSalahId().getDay(),
		// Month.of(salah.getSalahId().getMonth()),
		// salah.getSalahId().getOrganisation().getId().longValue(),
		// salah.getSalah().getFajr().toLocalTime(),
		// salah.getSalah().getSunrise().toLocalTime(),
		// salah.getSalah().getZuhr().toLocalTime(),
		// salah.getSalah().getAsr().toLocalTime(),
		// salah.getSalah().getMagrib().toLocalTime(),
		// salah.getSalah().getIsha().toLocalTime()));
		// }

		return dto;
	}
}
