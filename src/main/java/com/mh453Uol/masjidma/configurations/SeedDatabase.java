package com.mh453Uol.masjidma.configurations;

import java.sql.Time;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mh453Uol.masjidma.entities.DailySalah;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.User;
import com.mh453Uol.masjidma.repositories.DailySalahRespository;
import com.mh453Uol.masjidma.repositories.OrganisationRespository;
import com.mh453Uol.masjidma.repositories.UserRepository;

@Configuration
public class SeedDatabase {

	@SuppressWarnings("deprecation")
	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository, OrganisationRespository organisationRepository,
			DailySalahRespository dailySalahRespository) {
		return args -> {
			/*
			 * User me = new User("Majid", "Hussain"); me.getAudit().create(me);
			 * userRepository.save(me);
			 * 
			 * Organisation prayerRoomAtUol = new
			 * Organisation("ISOC University of Leicester", "University of Leicester");
			 * prayerRoomAtUol.getAudit().create(me);
			 * 
			 * organisationRepository.save(prayerRoomAtUol);
			 * 
			 * DailySalah saturday = new DailySalah(8, Month.SEPTEMBER.getValue(),
			 * prayerRoomAtUol); saturday.getSalah().setFajr(new Time(5, 0, 0));
			 * saturday.getSalah().setSunrise(new Time(6, 0, 0));
			 * saturday.getSalah().setZuhr(new Time(13, 30, 0));
			 * saturday.getSalah().setAsr(new Time(18, 0, 0));
			 * saturday.getSalah().setMagrib(new Time(20, 0, 0));
			 * saturday.getSalah().setIsha(new Time(21, 0, 0));
			 * 
			 * saturday.getAudit().create(me);
			 * 
			 * dailySalahRespository.save(saturday);
			 */
		};
	}
}
