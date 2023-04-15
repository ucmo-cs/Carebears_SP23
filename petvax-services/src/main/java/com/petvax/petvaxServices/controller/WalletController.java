package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.service.WalletsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.SystemException;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping
public class WalletController {
    private final WalletsService walletsService;

    @Autowired
    public WalletController(WalletsService walletsService) { this.walletsService = walletsService; }

    /**
     * Returns wallet by petId.
     *
     * @param petId Wallet
     */
    @ApiOperation(value = "getWalletByPetId",
            notes = "Returns wallet details by param petId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Wallet does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/wallets")
    public List<WalletsResponse> getVaccinationRecordByPetId(@RequestParam(required = false, defaultValue = "false") boolean active, @CookieValue(value = "petId") final String petId) throws SystemException {
        return walletsService.getWalletByPetId(active, petId);
    }

    /**
     * Returns wallet by walletId.
     *
     * @param walletId Wallet
     */
    @ApiOperation(value = "getWalletByWalletId",
            notes = "Returns wallet details by param walletId")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "wallet does not exist"),
            @ApiResponse(responseCode = "500", description = "System Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/wallets/{walletId}")
    public WalletsResponse getWalletByWalletId(@PathParam("walletId") boolean active, final String walletId) {
        return walletsService.getWalletByWalletId(active, walletId);
    }
}
