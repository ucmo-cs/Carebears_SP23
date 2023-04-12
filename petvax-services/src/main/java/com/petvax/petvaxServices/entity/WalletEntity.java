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

    @NotEmpty
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @NotEmpty
    @Column(
            name = "purpose",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String purpose;

    @ManyToOne
    @JoinColumn(name = "walletId", nullable = false, insertable = false, updatable = false)
    private WalletEntity walletEntity;

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
     * @return walletEntity
     */
    public WalletEntity getWalletEntity() {
        return walletEntity;
    }

    /**
     * @param walletEntity the walletEntity to set
     */
    public void setWalletEntity(WalletEntity walletEntity) {
        this.walletEntity = walletEntity;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
