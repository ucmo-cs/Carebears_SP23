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
        name = "pets",
        schema = "PETVAX",
        uniqueConstraints = {
                @UniqueConstraint(name = "pet_name_unique", columnNames = "name"),
                @UniqueConstraint(name = "pet_uuid_unique", columnNames = "uuid")
        }
)
public class PetEntity {
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
            name = "speciesID",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String speciesID;

    @NotEmpty
    @Column(
            name = "breedID",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String breedID;

    @NotEmpty
    @Column(
            name = "ownerID",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String ownerID;

    @NotEmpty
    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String age;

    @NotNull
    @Column(
            name = "active",
            nullable = false
    )
    private Boolean active;

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
     * @return speciesID
     */
    public String getSpeciesID() {
        return speciesID;
    }

    /**
     * @param speciesID the type to set
     */
    public void setSpeciesID(String speciesID) {
        this.speciesID = speciesID;
    }

    /**
     * @return breedID
     */
    public String getBreedID() {
        return breedID;
    }

    /**
     * @param breedID the age to set
     */
    public void setBreedID(String breedID) {
        this.breedID = breedID;
    }

    /**
     * @return ownerID
     */
    public String getOwnerID() {
        return ownerID;
    }

    /**
     * @param ownerID the type to set
     */
    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
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
