package com.mh453Uol.masjidma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mh453Uol.masjidma.entities.DailySalah;
import com.mh453Uol.masjidma.entities.SalahId;

public interface DailySalahRespository extends CrudRepository<DailySalah,SalahId> {
}
