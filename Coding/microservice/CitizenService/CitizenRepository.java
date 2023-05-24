package com.chuwa.CitizenService.repository;

import com.chuwa.CitizenService.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {

    public List<Citizen> findByVaccinationCenterId(Integer id);
}