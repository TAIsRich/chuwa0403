package com.codebase.microservices.VaccinationCenter.controller;

import com.codebase.microservices.VaccinationCenter.entity.VaccinationCenter;
import com.codebase.microservices.VaccinationCenter.model.Citizen;
import com.codebase.microservices.VaccinationCenter.model.RequiredResponse;
import com.codebase.microservices.VaccinationCenter.repository.CenterRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private CenterRepository centerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {

        VaccinationCenter vaccinationCenter1 = centerRepository.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenter, HttpStatus.OK);

    }

    @GetMapping("/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequiredResponse> getAllDataBasedonCenterId(@PathVariable Integer id) {

        RequiredResponse response = new RequiredResponse();
        //get vaccination center detail
        VaccinationCenter center = centerRepository.findById(id).get();
        response.setCenter(center);

        //then get all citizen registered in that center
        List<Citizen> listCitizen = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
        response.setCitizens(listCitizen);
        return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);

    }

    public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id) {

        RequiredResponse response = new RequiredResponse();
        //get vaccination center detail
        VaccinationCenter center = centerRepository.findById(id).get();
        response.setCenter(center);

        return new ResponseEntity<RequiredResponse>(response, HttpStatus.OK);
    }


}
