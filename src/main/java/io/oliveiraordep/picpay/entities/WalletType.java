package io.oliveiraordep.picpay.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    public WalletType() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
