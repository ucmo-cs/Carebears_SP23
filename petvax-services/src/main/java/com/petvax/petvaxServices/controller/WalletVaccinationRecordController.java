package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.WalletVaccinationRecordResponse;
import com.petvax.petvaxServices.service.WalletVaccinationRecordService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.SystemException;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class WalletVaccinationRecordController {

    private final WalletVaccinationRecordService walletVaccinationRecordService;

    @Autowired
    public WalletVaccinationRecordController(WalletVaccinationRecordService walletVaccinationRecordService) { this.walletVaccinationRecordService = walletVaccinationRecordService; }

    /**
     * Returns wallet vaccination record by petId.
     *
     * @param walletId Vaccination
     */
    @ApiOperation(value = "findVaccinationRecordByWalletId",
            notes = "Returns vaccination record details by param petId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "vaccination record does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/wallets/vaccinationRecord")
    public List<WalletVaccinationRecordResponse> findVaccinationRecordByWalletId(@RequestParam(required = false, defaultValue = "false") boolean active, @CookieValue(value = "walletId") final String walletId, HttpServletResponse response) throws SystemException {
        Cookie cookie = new Cookie("walletId", walletId);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return walletVaccinationRecordService.findVaccinationRecordByWalletId(active, walletId);
    }

}
