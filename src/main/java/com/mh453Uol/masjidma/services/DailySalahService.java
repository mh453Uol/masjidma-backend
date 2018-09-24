package com.mh453Uol.masjidma.services;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mh453Uol.masjidma.dtos.JamaatPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.MasjidPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.MonthlyPrayerTimeDto;
import com.mh453Uol.masjidma.dtos.PrayerStartTimeDto;
import com.mh453Uol.masjidma.entities.JamaatPrayerTime;
import com.mh453Uol.masjidma.entities.MasjidPrayerTime;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.PrayerId;
import com.mh453Uol.masjidma.entities.PrayerStartTime;
import com.mh453Uol.masjidma.entities.User;
import com.mh453Uol.masjidma.exceptions.NotFoundException;
import com.mh453Uol.masjidma.repositories.DailySalahRespository;
import com.mh453Uol.masjidma.utils.*;

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

		dto.setJamaatTimes(new JamaatPrayerTimeDto(
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

	public void saveMontlySalahs(MonthlyPrayerTimeDto dto) {
		ArrayList<MasjidPrayerTime> prayerTimes = new ArrayList<MasjidPrayerTime>();
		PrayerStartTimeDto startTime = null;
		JamaatPrayerTimeDto jamaatTime = null;
		MasjidPrayerTime masjidPrayerTime = null;
		
		 for (MasjidPrayerTimeDto prayerTimesDto : dto.getPrayerTimes()) {
			 
			 startTime = prayerTimesDto.getStartPrayerTimes();
			 jamaatTime = prayerTimesDto.getJamaatTimes();
			 
			 masjidPrayerTime = new MasjidPrayerTime(prayerTimesDto.getDay(), 
					 dto.getMonth(), new Organisation(dto.getOrganisationId()),
					 
					 new PrayerStartTime(Time.toSqlTime(startTime.getFajr()), Time.toSqlTime(startTime.getSunrise()),
							 Time.toSqlTime(startTime.getZuhr()),Time.toSqlTime(startTime.getAsr()), 
							 Time.toSqlTime(startTime.getIsha())),
					 
					 new JamaatPrayerTime(Time.toSqlTime(jamaatTime.getFajr()), Time.toSqlTime(jamaatTime.getZuhr()),
							 Time.toSqlTime(jamaatTime.getAsr()), Time.toSqlTime(jamaatTime.getMagrib()), 
							 Time.toSqlTime(jamaatTime.getIsha()))
					 );
		 		
			 masjidPrayerTime.getAudit().create(new User(1L));
			 //hibernate by default does a select to see if the record already exists if
			 //it does then it issues a UPDATE or INSERT
			 prayerTimes.add(masjidPrayerTime);
		 }
		dailySalahRepo.saveAll(prayerTimes);
	}

	public MonthlyPrayerTimeDto getMonthlySalahs(Month month, long organisationId) {
		Iterable<MasjidPrayerTime> prayerTimes = this.dailySalahRepo
				.findBySalahIdMonthAndSalahIdOrganisation(month.getValue(), new Organisation(organisationId));

		MonthlyPrayerTimeDto dto = new MonthlyPrayerTimeDto(month, organisationId);
		JamaatPrayerTime jamaatTime = null;
		PrayerStartTime startTime = null;
		
		 for(MasjidPrayerTime salah: prayerTimes) {
			 jamaatTime = salah.getJammatTimes();
			 startTime = salah.getSalahStartTimes();
			 
			 dto.getPrayerTimes().add(new MasjidPrayerTimeDto(
					 salah.getSalahId().getDay(),
					 Month.of(salah.getSalahId().getMonth()), 
					 salah.getSalahId().getOrganisation().getId(), 
					 
					 new PrayerStartTimeDto(startTime.getFajrStartTime().toLocalTime(), 
							 startTime.getSunriseStartTime().toLocalTime(),
							 startTime.getZuhrStartTime().toLocalTime(),
							 startTime.getAsrStartTime().toLocalTime(),
							 startTime.getIshaStartTime().toLocalTime()),
					 
					 new JamaatPrayerTimeDto(jamaatTime.getJamaatFajr().toLocalTime(), 
							 jamaatTime.getJamaatZuhr().toLocalTime(),
							 jamaatTime.getJamaatAsr().toLocalTime(),
							 jamaatTime.getJamaatMagrib().toLocalTime(),
							 jamaatTime.getJamaatIsha().toLocalTime())
					 ));
			 
		 }

		return dto;
	}
}
