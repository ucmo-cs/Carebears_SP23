package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.VaccinationRecordResponse;
import com.petvax.petvaxServices.service.VaccinationRecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import java.util.List;

@RestController
@RequestMapping
public class VaccinationRecordController {

    private final VaccinationRecordService vaccinationRecordService;

    @Autowired
    public VaccinationRecordController(VaccinationRecordService vaccinationRecordService) { this.vaccinationRecordService = vaccinationRecordService; }

    /**
     * Returns vaccination by name.
     *
     * @param petId Vaccination
     */
    @ApiOperation(value = "getVaccinationRecordByPetId",
            notes = "Returns vaccination record details by param petId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination record does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/vaccinationRecord")
    @PreAuthorize("hasRole('USER')")
    public List<VaccinationRecordResponse> getVaccinationRecordByPetId(@RequestParam(required = false, defaultValue = "false") boolean active, @CookieValue(value = "petId") final String petId) throws SystemException {
        return vaccinationRecordService.getVaccinationRecordByPetId(active, petId);
    }

}
