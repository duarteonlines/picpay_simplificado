package io.oliveiraordep.picpay.controllers.dtos;

import io.oliveiraordep.picpay.entities.Wallet;
import io.oliveiraordep.picpay.entities.WalletType;
import io.oliveiraordep.picpay.enums.WalletTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateWalletDto(@NotBlank String fullName,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletTypeEnum walletType) {

    public Wallet toWallet()  {
        return new Wallet(fullName, cpfCnpj, password, email,walletType.getWalletType());
    }
}
