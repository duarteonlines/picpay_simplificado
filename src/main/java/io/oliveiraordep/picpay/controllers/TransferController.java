package io.oliveiraordep.picpay.controllers;

import io.oliveiraordep.picpay.controllers.dtos.TransferDto;
import io.oliveiraordep.picpay.entities.Transfer;
import io.oliveiraordep.picpay.services.TransferService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDto data){
        var response = transferService.transfer(data);
        return ResponseEntity.ok(response);
    }
}
