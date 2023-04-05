package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.VaccinationsRequest;
import com.petvax.petvaxServices.dto.VaccinationsResponse;
import com.petvax.petvaxServices.service.VaccinationsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping
public class VaccinationsController {

    private final VaccinationsService vaccinationsService;

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
    @GetMapping(path="/vaccinations", params = "name")
    public VaccinationsResponse getVaccinationByName(@RequestParam(required = false) String name) {
        return vaccinationsService.getVaccination(name);
    }

    /**
     * Returns vaccination by ID.
     *
     * @param uuid Vaccination
     */
    @ApiOperation(value = "getVaccinationById",
            notes = "Returns vaccination details by param id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/vaccinations/{uuid}")
    public VaccinationsResponse getVaccinationByUuid(@PathParam("uuid") final String uuid) {
        return vaccinationsService.getVaccinationByUuid(uuid);
    }

    /**
     * Returns vaccination by type.
     *
     * @param type Vaccination
     */
    @ApiOperation(value = "getVaccinationByType",
            notes = "Returns vaccination details by param type")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/vaccinationType", params = "type")
    public List<VaccinationsResponse> getVaccinationByType(@RequestParam(required = false) String type) throws SystemException {
        return vaccinationsService.getVaccinationByType(type);
    }

    /**
     * Returns vaccination by species
     *
     * @param species Vaccination
     */
    @ApiOperation(value = "getVaccinationBySpecies",
            notes = "Returns vaccination details by param species")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/vaccinationSpecies", params = "species")
    public List<VaccinationsResponse> getVaccinationBySpecies(@RequestParam(required = false) String species) throws SystemException {
        return vaccinationsService.getVaccinationBySpecies(species);
    }

    /**
     * Creates vaccination.
     *
     * @param vaccination Vaccination details
     */
    @ApiOperation(value = "createVaccination",
            notes = "Creates vaccination")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/vaccinations")
    public VaccinationsResponse createVaccination(@RequestBody @Valid final VaccinationsRequest vaccination) {
        return vaccinationsService.createVaccination(vaccination);
    }

    /**
     * Updates vaccination.
     *
     * @param vaccination Vaccination details
     */
    @ApiOperation(value = "updateVaccination",
            notes = "Updates vaccination")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path="/vaccinations/{vaccinationId}")
    public VaccinationsResponse updateVaccination(@RequestBody @Valid final VaccinationsRequest vaccination, @PathVariable final String vaccinationId) {
        return vaccinationsService.updateVaccination(vaccination, vaccinationId);
    }

    /**
     * Deletes vaccination.
     */
    @ApiOperation(value = "deleteVaccination",
            notes = "Deletes vaccination")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "vaccination id is invalid"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path="/vaccinations/{vaccinationId}")
    public void deleteVaccination(@PathVariable final String vaccinationId) {
        vaccinationsService.deleteVaccination(vaccinationId);
    }
}
