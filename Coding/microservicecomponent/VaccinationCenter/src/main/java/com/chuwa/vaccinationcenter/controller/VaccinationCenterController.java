package com.chuwa.vaccinationcenter.controller;

import com.chuwa.vaccinationcenter.entity.VaccinationCenter;
import com.chuwa.vaccinationcenter.model.Citizen;
import com.chuwa.vaccinationcenter.model.RequireResponse;
import com.chuwa.vaccinationcenter.repository.CenterRepository;
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
//    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequireResponse> getAllDataBasedonCenterId(@PathVariable Integer id) {

        RequireResponse response = new RequireResponse();
        //get vaccination center detail
        VaccinationCenter center = centerRepository.findById(id).get();
        response.setCenter(center);

        //then get all citizen registered in that center
        List<Citizen> listCitizen = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
        response.setCitizens(listCitizen);
        return new ResponseEntity<RequireResponse>(response, HttpStatus.OK);

    }

//    public ResponseEntity<RequireResponse> handleCitizenDownTime(@PathVariable Integer id) {
//
//        RequireResponse response = new RequireResponse();
//        //get vaccination center detail
//        VaccinationCenter center = centerRepository.findById(id).get();
//        response.setCenter(center);
//
//        return new ResponseEntity<RequireResponse>(response, HttpStatus.OK);
//    }

}
