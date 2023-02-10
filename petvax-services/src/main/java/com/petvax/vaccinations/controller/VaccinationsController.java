package com.petvax.vaccinations.controller;

import com.petvax.vaccinations.entity.VaccinationEntity;
import com.petvax.vaccinations.repository.VaccinationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccinationsController {

    VaccinationsRepository vaccinationsRepository;

    @Autowired
    public VaccinationsController(VaccinationsRepository vaccinationsRepository) { this.vaccinationsRepository = vaccinationsRepository; }

    @GetMapping("/vaccinations")
    public String getVaccinationByName(@RequestParam String name) {

        VaccinationEntity vaccination = vaccinationsRepository.findByName(name);

        return vaccination.toString();
    }

}
