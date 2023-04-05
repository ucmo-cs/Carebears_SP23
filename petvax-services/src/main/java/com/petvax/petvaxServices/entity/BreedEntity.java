package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(
        name = "breeds",
        schema = "PETVAX",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public final class BreedEntity {
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
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciesId")
    private SpeciesEntity speciesEntity;

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
     * @return fname
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
     * @return speciesEntity
     */
    public SpeciesEntity getSpeciesEntity() {
        return speciesEntity;
    }

    /**
     * @param speciesEntity the speciesEntity to set
     */
    public void setSpeciesEntity(SpeciesEntity speciesEntity) {
        this.speciesEntity = speciesEntity;
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
