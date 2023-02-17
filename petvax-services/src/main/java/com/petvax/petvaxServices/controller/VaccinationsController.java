package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.service.VaccinationsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vaccinations")
public class VaccinationsController {

    VaccinationsService vaccinationsService;

    @Autowired
    public VaccinationsController(VaccinationsService vaccinationsService) { this.vaccinationsService = vaccinationsService; }

    /**
     * Returns vaccination by name.
     *
     * @param name Vaccination
     */
    @ApiOperation(value = "getVaccinationByName",
            notes = "Returns vaccination details by param name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = "name")
    public VaccinationsResponse getVaccinationByName(@RequestParam(required = false) String name) {
        return vaccinationsService.getVaccination(name);
    }
}
