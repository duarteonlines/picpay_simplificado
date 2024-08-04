package io.oliveiraordep.picpay.controllers;

import io.oliveiraordep.picpay.controllers.dtos.CreateWalletDto;
import io.oliveiraordep.picpay.entities.Wallet;
import io.oliveiraordep.picpay.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;


    @PostMapping("/wallets")
    public ResponseEntity<Wallet> createWallet(@RequestBody @Valid CreateWalletDto data) {
        var wallet = walletService.createWallet(data);
        return ResponseEntity.ok().body(wallet);
    }
}
