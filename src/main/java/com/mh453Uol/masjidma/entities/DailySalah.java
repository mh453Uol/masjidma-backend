package com.mh453Uol.masjidma.entities;

import java.sql.Time;
import java.time.Month;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dailysalah")
public class DailySalah {

	@EmbeddedId
	private SalahId salahId;

	@Embedded
	private Salah salah;

	@Embedded
	private Audit audit;

	public DailySalah() {
		this.audit = new Audit();
		this.salah = new Salah();
	}

	public DailySalah(int day, int month, Organisation organisation) {
		this();
		this.salahId = new SalahId(day, month, organisation);
	}

	public DailySalah(int day, int month, Organisation organisation, Time sunrise, Time fajr, Time zuhr, Time asr,
			Time magrib, Time isha) {
		this(day, month, organisation);

		this.salah.setSunrise(sunrise);
		this.salah.setFajr(fajr);
		this.salah.setZuhr(zuhr);
		this.salah.setAsr(asr);
		this.salah.setMagrib(magrib);
		this.salah.setIsha(isha);
	};

	public Salah getSalah() {
		return salah;
	}

	public void setSalah(Salah salah) {
		this.salah = salah;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public SalahId getSalahId() {
		return salahId;
	}

	public void setSalahId(SalahId salahId) {
		this.salahId = salahId;
	}
}
