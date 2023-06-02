package com.codebase.microservices.CitizenService.controller;

import com.codebase.microservices.CitizenService.entity.Citizen;
import com.codebase.microservices.CitizenService.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private CitizenRepository repo;

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        List<Citizen> listCitizen = repo.findByVaccinationCenterId(id);
        return new ResponseEntity<>(listCitizen, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
        Citizen citizen = repo.save(newCitizen);
        return  new ResponseEntity<>(citizen, HttpStatus.OK);
    }
}
