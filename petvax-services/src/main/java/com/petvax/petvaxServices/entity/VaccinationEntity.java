package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.Instant;

@Entity
@Table(
        name = "vaccinations",
        schema = "PETVAX",
        uniqueConstraints = {
                @UniqueConstraint(name = "vaccine_name_unique", columnNames = "name"),
                @UniqueConstraint(name = "vaccine_uuid_unique", columnNames = "uuid")
        }
)
public final class VaccinationEntity {
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
    @NotEmpty
    @Column(
            name = "type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String type;
    @NotNull
    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String age;
    @NotNull
    @Column(
            name = "frequency",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String frequency;
    @NotEmpty
    @Column(
            name = "species",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String species;

    @CreationTimestamp
    @Column(
            name = "createdDate",
            updatable = false)
    private Instant createdDate;

    /**
     * @return name
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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return createdDate
     */
    public Instant getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(final Instant createdDate) {
        this.createdDate = createdDate;
    }

}
