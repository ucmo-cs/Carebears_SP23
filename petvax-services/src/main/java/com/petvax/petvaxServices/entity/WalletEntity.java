package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(
        name = "wallets",
        schema = "PETVAX"
)
public final class WalletEntity {
    @Column(
            name = "uuid",
            insertable = false,
            updatable = false
    )
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @NotEmpty
    @Column(
            name = "walletId",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String walletId;

    /**
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the name to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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
}
