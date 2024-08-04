package io.oliveiraordep.picpay.services;

import io.oliveiraordep.picpay.controllers.dtos.CreateWalletDto;
import io.oliveiraordep.picpay.entities.Wallet;
import io.oliveiraordep.picpay.exceptions.WalletDataAlreadyExists;
import io.oliveiraordep.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository repository;

    public Wallet createWallet(CreateWalletDto data) {

        verifyExists(data);
        return repository.save(data.toWallet());
    }

    private void verifyExists(CreateWalletDto data) {
        var exists = repository.findByCpfCnpjOrEmail(data.cpfCnpj(), data.email());
        if(exists.isPresent()) {
            throw new WalletDataAlreadyExists("CpfCnpj or email already exists");
        }
    }
}
