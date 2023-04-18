package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.PetsResponse;
import com.petvax.petvaxServices.service.PetsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping
public class PetsController {

    private final PetsService petsService;

    @Autowired
    public PetsController(PetsService petsService) { this.petsService = petsService; }

    /**
     * Returns pet by name.
     *
     * @param name Pet
     */
    @ApiOperation(value = "getPetByName",
            notes = "Returns pet details by param name")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "pet does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/pets", params = "name")
    public PetsResponse getPetByName(@RequestParam(required = false) String name) {
        return petsService.getPet(name);
    }

    /**
     * Returns pet by ID.
     *
     * @param petId Pet
     */
    @ApiOperation(value = "getPetById",
            notes = "Returns pet details by param id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "pet does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/pets/{petId}")
    public PetsResponse getPetByPetId(@PathParam("petId") final String petId) {
        return petsService.getPetByUuid(petId);
    }

    /**
     * Returns pet by ownerID.
     *
     * @param ownerID Pet
     */
    @ApiOperation(value = "getPetByOwnerID",
            notes = "Returns pet details by param ownerID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "pet does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/pets")
    public List<PetsResponse> getPetByOwnerID(@RequestParam(required = false, defaultValue = "false") boolean active, @CookieValue(value = "ownerID") final String ownerID, HttpServletResponse response) throws SystemException {
        Cookie cookie = new Cookie("ownerID", ownerID);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return petsService.getPetByOwnerID(active, ownerID);
    }
}
