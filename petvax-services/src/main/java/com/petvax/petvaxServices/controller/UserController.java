package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.LoginResponse;
import com.petvax.petvaxServices.dto.UserResponse;
import com.petvax.petvaxServices.entity.UserEntity;
import com.petvax.petvaxServices.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import javax.websocket.server.PathParam;
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
    public ResponseEntity<LoginResponse> login(@RequestBody(required = true) Map<String, String> requestMap) {
        return userService.login(requestMap);
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

    @ApiOperation(value = "findByUsername")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "user not found"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/userDetails")
    public UserResponse findByUsername(@RequestParam(required = false) String username) throws SystemException {
        return userService.findByUsername(username);
    }
}
