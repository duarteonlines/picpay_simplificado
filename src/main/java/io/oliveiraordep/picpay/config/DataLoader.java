package io.oliveiraordep.picpay.config;

import io.oliveiraordep.picpay.entities.WalletType;
import io.oliveiraordep.picpay.enums.WalletTypeEnum;
import io.oliveiraordep.picpay.repositories.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository walletTypeRepository;
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletTypeEnum.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
