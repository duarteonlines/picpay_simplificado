package io.oliveiraordep.picpay.repositories;

import io.oliveiraordep.picpay.entities.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {

}
