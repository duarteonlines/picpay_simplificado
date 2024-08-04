package io.oliveiraordep.picpay.repositories;

import io.oliveiraordep.picpay.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
