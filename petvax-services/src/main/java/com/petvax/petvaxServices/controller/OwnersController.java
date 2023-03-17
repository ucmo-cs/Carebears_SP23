package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.OwnersResponse;
import com.petvax.petvaxServices.service.OwnersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class OwnersController {

    private final OwnersService ownersService;

    @Autowired
    public OwnersController(OwnersService ownersService) { this.ownersService = ownersService; }

    /**
     * Returns owner by username.
     *
     * @param username Owner
     */
    @ApiOperation(value = "findOwnerByUserName",
            notes = "Returns owner details by param username")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "username does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/owner/{username}")
    public OwnersResponse findOwnerByUserName(@PathVariable("username") final String username) {
        return ownersService.findOwnerByUserName(username);
    }
}
