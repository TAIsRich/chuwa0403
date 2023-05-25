package com.chuwa.vaccinationcenter.repository;

import com.chuwa.vaccinationcenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer> {
}
