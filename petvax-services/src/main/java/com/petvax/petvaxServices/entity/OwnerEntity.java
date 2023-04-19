package com.petvax.petvaxServices.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Entity
@Table(
        name = "owners",
        schema = "PETVAX"
)
public final class OwnerEntity {
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
            name = "fname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fname;
    @NotEmpty
    @Column(
            name = "lname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lname;
    @NotNull
    @Column(
            name = "address1",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address1;
    @NotEmpty
    @Column(
            name = "address2",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String address2;
    @NotNull
    @Column(
            name = "city",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String city;
    @NotNull
    @Column(
            name = "state",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String state;
    @NotNull
    @Column(
            name = "zipCode",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String zipCode;
    @NotEmpty
    @Email
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "VARCHAR(99)"
    )
    private String email;

    @OneToOne
    @JoinColumn(name = "uuid",nullable = false, insertable = false, updatable = false)
    private UserEntity userEntity;

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
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the name to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the name to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the name to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the name to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the name to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the name to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the name to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the name to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
