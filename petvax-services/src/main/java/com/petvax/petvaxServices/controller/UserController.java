package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    public Exception exception;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "login")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "user does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            return userService.login(requestMap);
        } catch (Exception ex) {
            ResponseEntity<String> message = new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
            return message;
        }
    }

    @ApiOperation(value = "checkToken")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "bad token"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/checkToken")
    public ResponseEntity<String> checkToken() {
        try {
            return userService.checkToken();
        } catch (Exception ex) {
            ResponseEntity<String> message = new ResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
            return message;
        }
    }
}
