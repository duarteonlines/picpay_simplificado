package io.oliveiraordep.picpay.enums;

import io.oliveiraordep.picpay.entities.WalletType;

public enum WalletTypeEnum {
    USER(1L, "user"),
    MERCHANT(2L, "merchant");

    private final Long id;
    private final String description;

    private WalletTypeEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public WalletType getWalletType() {
        return new WalletType(id, description);
    }

}
