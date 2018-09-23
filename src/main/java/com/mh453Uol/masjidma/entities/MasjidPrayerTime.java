package com.mh453Uol.masjidma.entities;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "masjidPrayerTimes")
public class MasjidPrayerTime {

	@EmbeddedId
	private PrayerId salahId;

	@Embedded
	private JamaatPrayerTime jammatTimes;
	
	@Embedded
	private PrayerStartTime salahStartTimes;
	
	@Embedded
	private Audit audit;

	public MasjidPrayerTime() {
		this.audit = new Audit();
		this.jammatTimes = new JamaatPrayerTime();
		this.salahStartTimes = new PrayerStartTime();
	}

	public MasjidPrayerTime(int day, int month, Organisation organisation) {
		this();
		this.salahId = new PrayerId(day, month, organisation);
	}

	public MasjidPrayerTime(int day, int month, Organisation organisation, PrayerStartTime startTime, 
			JamaatPrayerTime jammatSalahTimes) {
		this(day, month, organisation);
		this.salahStartTimes = startTime;
		this.jammatTimes = jammatSalahTimes;
	};

	public JamaatPrayerTime getJammatTimes() {
		return jammatTimes;
	}

	public void setJammatTimes(JamaatPrayerTime jammatTimes) {
		this.jammatTimes = jammatTimes;
	}

	public PrayerStartTime getSalahStartTimes() {
		return salahStartTimes;
	}

	public void setSalahStartTimes(PrayerStartTime salahStartTimes) {
		this.salahStartTimes = salahStartTimes;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public PrayerId getSalahId() {
		return salahId;
	}

	public void setSalahId(PrayerId salahId) {
		this.salahId = salahId;
	}
}
