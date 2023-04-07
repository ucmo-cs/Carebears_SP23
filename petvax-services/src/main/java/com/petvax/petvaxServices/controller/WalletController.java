package com.petvax.petvaxServices.controller;

import com.petvax.petvaxServices.dto.WalletsResponse;
import com.petvax.petvaxServices.service.WalletsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping
public class WalletController {
    private final WalletsService walletsService;

    @Autowired
    public WalletController(WalletsService walletsService) { this.walletsService = walletsService; }

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
    public WalletsResponse getWalletByWalletId(@PathParam("walletId") final String walletId) {
        return walletsService.getWalletByWalletId(walletId);
    }
}
