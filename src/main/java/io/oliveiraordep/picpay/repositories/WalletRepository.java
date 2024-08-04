package io.oliveiraordep.picpay.repositories;

import io.oliveiraordep.picpay.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
