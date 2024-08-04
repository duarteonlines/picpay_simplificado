package io.oliveiraordep.picpay.controllers.dtos;

import io.oliveiraordep.picpay.entities.Wallet;
import io.oliveiraordep.picpay.entities.WalletType;
import io.oliveiraordep.picpay.enums.WalletTypeEnum;

public record CreateWalletDto(String fullName,
                              String cpfCnpj,
                              String email,
                              String password,
                              WalletTypeEnum walletType) {

    public Wallet toWallet()  {
        return new Wallet(fullName, cpfCnpj, password, email,walletType.getWalletType());
    }
}
