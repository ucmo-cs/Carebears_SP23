package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.BreedsResponse;
import com.petvax.petvaxServices.entity.BreedEntity;
import com.petvax.petvaxServices.entity.SpeciesEntity;
import com.petvax.petvaxServices.repository.BreedsRepository;
import com.petvax.petvaxServices.repository.SpeciesRepository;
import com.petvax.petvaxServices.service.BreedsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import java.util.List;

@RestController
@RequestMapping
public class BreedsController {

    private final BreedsService breedsService;
    private final BreedsRepository breedsRepository;
    private final SpeciesRepository speciesRepository;

    @Autowired
    public BreedsController(BreedsService breedsService,
                            BreedsRepository breedsRepository,
                            SpeciesRepository speciesRepository) { this.breedsService = breedsService;
        this.breedsRepository = breedsRepository;
        this.speciesRepository = speciesRepository;
    }

    /**
     * Returns Breed by name.
     *
     * @param name Breed
     */
    @ApiOperation(value = "getBreedByName",
            notes = "Returns Breed details by param name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Breed does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/breed", params = "name")
    public BreedsResponse getBreedByName(@RequestParam(required = false) String name) {
        return breedsService.getBreedByName(name);
    }

}
