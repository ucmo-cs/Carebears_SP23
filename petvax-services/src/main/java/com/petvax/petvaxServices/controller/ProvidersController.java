package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.ProvidersResponse;
import com.petvax.petvaxServices.service.ProvidersService;
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
public class ProvidersController {

    private final ProvidersService providersService;

    @Autowired
    public ProvidersController(ProvidersService providersService) { this.providersService = providersService; }

    /**
     * Returns provider by name.
     *
     * @param name Provider
     */
    @ApiOperation(value = "getProviderByName",
            notes = "Returns provider details by param name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "provider does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/provider", params = "name")
    public ProvidersResponse getProviderByName(@RequestParam(required = false) String name) {
        return providersService.getProviderByName(name);
    }

    /**
     * Returns vaccination by city.
     *
     * @param city Vaccination
     */
    @ApiOperation(value = "getProvidersByCity",
            notes = "Returns provider details by param city")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "provider does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/providers", params = "city")
    public List<ProvidersResponse> getProvidersByCity(@RequestParam(required = false) String city) throws SystemException {
        return providersService.getProvidersByCity(city);
    }

}
