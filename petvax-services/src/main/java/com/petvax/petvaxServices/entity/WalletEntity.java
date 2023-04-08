package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
        name = "wallets",
        schema = "PETVAX"
)
public final class WalletEntity {
    @Column(
            name = "walletId",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String walletId;

    @NotEmpty
    @Column(
            name = "petId",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String petId;

    @NotNull
    @Column(
            name = "active",
            nullable = false
    )
    private Boolean active;

    /**
     * @return walletId
     */
    public String getWalletId() {
        return walletId;
    }

    /**
     * @param walletId the walletId to set
     */
    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    /**
     * @return petId
     */
    public String getPetId() {
        return petId;
    }

    /**
     * @param petId the petId to set
     */
    public void setPetId(String petId) {
        this.petId = petId;
    }

    /**
     * @return active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the name to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
}
