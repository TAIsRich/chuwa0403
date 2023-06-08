package com.codebase.microservices.VaccinationCenter.repository;

import com.codebase.microservices.VaccinationCenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.DocFlavor;


public interface CenterRepository extends JpaRepository<VaccinationCenter, Integer> {


}
