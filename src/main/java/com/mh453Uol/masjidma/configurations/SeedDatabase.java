package com.mh453Uol.masjidma.configurations;

import java.sql.Time;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mh453Uol.masjidma.entities.JamaatPrayerTime;
import com.mh453Uol.masjidma.entities.MasjidPrayerTime;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.PrayerStartTime;
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
			
			if(dailySalahRespository.count() > 0) {
				return;
			}
			
			 User me = new User("Majid", "Hussain"); me.getAudit().create(me);
			 userRepository.save(me);
			 
			 Organisation prayerRoomAtUol = new
			 Organisation("ISOC University of Leicester", "University of Leicester");
			 prayerRoomAtUol.getAudit().create(me);
			  
			 organisationRepository.save(prayerRoomAtUol);
			 
			 MasjidPrayerTime saturday = new MasjidPrayerTime(8, Month.SEPTEMBER.getValue(),prayerRoomAtUol); 
			 
			 saturday.setJammatTimes(new JamaatPrayerTime(new Time(1,1,1),
					 new Time(1,1,1),new Time(1,1,1),
					 new Time(1,1,1),new Time(1,1,1)));
			 
			 saturday.setSalahStartTimes(new PrayerStartTime(new Time(1,1,1),
					 new Time(1,1,1),new Time(1,1,1),
					 new Time(1,1,1),new Time(1,1,1)));
			 
			 saturday.getAudit().create(me);
			 
			 dailySalahRespository.save(saturday);
	
		};
	}
}
