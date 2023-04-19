package com.petvax.petvaxServices.entity;

import com.petvax.petvaxServices.dto.SpeciesResponse;
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

    @ManyToOne
    @JoinColumn(
            name = "speciesID",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private SpeciesEntity speciesEntity;

    @ManyToOne
    @JoinColumn(
            name = "breedID",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private BreedEntity breedEntity;

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
     * @return breedEntity
     */
    public BreedEntity getBreedEntity() {
        return breedEntity;
    }

    /**
     * @param breedEntity the breedEntity to set
     */
    public void setBreedEntity(BreedEntity breedEntity) {
        this.breedEntity = breedEntity;
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
