package io.oliveiraordep.picpay.services;

import io.oliveiraordep.picpay.controllers.dtos.TransferDto;
import io.oliveiraordep.picpay.entities.Transfer;
import io.oliveiraordep.picpay.entities.Wallet;
import io.oliveiraordep.picpay.exceptions.InsufficientBalanceException;
import io.oliveiraordep.picpay.exceptions.TransferNotAllowedForWalletTypeException;
import io.oliveiraordep.picpay.exceptions.TransferNotAuthorizedException;
import io.oliveiraordep.picpay.exceptions.WalletNotFoundException;
import io.oliveiraordep.picpay.repositories.TransferRepository;
import io.oliveiraordep.picpay.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    @Autowired
    TransferRepository transferRepository;
    @Autowired
    AuthorizationService authorizationService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    WalletRepository walletRepository;

    @Transactional
    public Transfer transfer(TransferDto data) {
        var sender = isExistsUser(data.payer());
        var receiver = isExistsUser(data.payee());

        validateTransfer(data, sender);

        sender.debit(data.value());
        receiver.credit(data.value());

        var transfer = new Transfer(sender, receiver, data.value());
        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDto data, Wallet sender) {
        if(!sender.isTransferAllowedForWalletType()){
            throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalanceBiggerThan(data.value())){
            throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized(data)) {
            throw new TransferNotAuthorizedException();
        }
    }

    private Wallet isExistsUser(Long user) {
        return walletRepository.findById(user).orElseThrow(() -> new WalletNotFoundException(user));
    }
}
