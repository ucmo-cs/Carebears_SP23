package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "vaccinations",
        schema = "PETVAX",
        uniqueConstraints = {
                @UniqueConstraint(name = "vaccine_name_unique", columnNames = "name")
        }
)
public class VaccinationEntity {

    @Id
    @SequenceGenerator(
        name = "vaccination_sequence",
        sequenceName = "vaccination_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "vaccination_sequence"
    )

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String type;
    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String age;
    @Column(
            name = "frequency",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String frequency;
    @Column(
            name = "species",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String species;

    @CreatedDate
    @Column(
            name = "createdDate",
            updatable = false)
    private Instant createdDate;

    // Empty entity constructor
    public VaccinationEntity() {
    }

    // Entity Constructor
    public VaccinationEntity(String name,
                             String type,
                             String age,
                             String frequency,
                             String species,
                             Instant createdDate) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.frequency = frequency;
        this.species = species;
        this.createdDate = createdDate;
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
