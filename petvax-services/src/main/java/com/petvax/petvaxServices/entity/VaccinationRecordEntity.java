package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(
        name = "vaccinationRecords",
        schema = "PETVAX"
)
public final class VaccinationRecordEntity implements Serializable {
    @Column(
            name = "uuid",
            insertable = false,
            updatable = false
    )
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String uuid;

    @NotEmpty
    @Column(
            name = "petId",
            nullable = false
    )
    private String petId;

    @ManyToOne
    @JoinColumn(name = "vaccinationId", nullable = false, insertable = false, updatable = false)
    private VaccinationEntity vaccinationEntity;

    @NotEmpty
    @Column(
            name = "vaccinationDate",
            nullable = false
    )
    private Instant vaccinationDate;

    @CreationTimestamp
    @Column(
            name = "createdDate",
            updatable = false
    )
    private Instant createdDate;

    @UpdateTimestamp
    @Column(
            name = "updatedDate"
    )
    private Instant updatedDate;

    @NotNull
    @Column(
            name = "active",
            nullable = false
    )
    private Boolean active;

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
     * @return vaccinationEntity
     */
    public VaccinationEntity getVaccinationEntity() {
        return vaccinationEntity;
    }

    /**
     * @param vaccinationEntity the vaccinationEntity to set
     */
    public void setVaccinationEntity(VaccinationEntity vaccinationEntity) {
        this.vaccinationEntity = vaccinationEntity;
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
     * @return vaccinationDate
     */
    public Instant getVaccinationDate() {
        return vaccinationDate;
    }

    /**
     * @param vaccinationDate the name to set
     */
    public void setVaccinationDate(Instant vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
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

    /**
     * @return updatedDate
     */
    public Instant getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the name to set
     */
    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
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
