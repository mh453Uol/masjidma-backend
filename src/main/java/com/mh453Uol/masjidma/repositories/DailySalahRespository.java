package com.mh453Uol.masjidma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mh453Uol.masjidma.entities.MasjidPrayerTime;
import com.mh453Uol.masjidma.entities.Organisation;
import com.mh453Uol.masjidma.entities.PrayerId;

public interface DailySalahRespository extends CrudRepository<MasjidPrayerTime,PrayerId> {
	public Iterable<MasjidPrayerTime> findBySalahIdMonthAndSalahIdOrganisation(int month, Organisation organisation);
}
