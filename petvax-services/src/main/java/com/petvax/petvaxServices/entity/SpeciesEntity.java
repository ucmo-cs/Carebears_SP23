package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Entity
@Table(
        name = "species",
        schema = "PETVAX",
        uniqueConstraints = @UniqueConstraint(columnNames = "speciesName")
)
public final class SpeciesEntity {
    @Column(
            name = "uuid",
            nullable = false,
            columnDefinition = "TEXT"
    )
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @NotEmpty
    @Column(
            name = "speciesName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String speciesName;

    @CreationTimestamp
    @Column(
            name = "createdDate",
            updatable = false)
    private Instant createdDate;

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
     * @return speciesName
     */
    public String getSpeciesName() {
        return speciesName;
    }

    /**
     * @param speciesName the name to set
     */
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    /**
     * @return createdDate
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the name to set
     */
    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }
}
