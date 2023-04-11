package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.SpeciesResponse;
import com.petvax.petvaxServices.service.SpeciesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) { this.speciesService = speciesService; }

    /**
     * Returns Species by name.
     *
     * @param speciesName Species
     */
    @ApiOperation(value = "getSpecieByName",
            notes = "Returns Specie details by param speciesName")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "species does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/species", params = "speciesName")
    @PreAuthorize("hasRole('USER')")
    public SpeciesResponse getSpeciesByName(@RequestParam(required = false) String speciesName) {
        return speciesService.getSpeciesByName(speciesName);
    }
}
