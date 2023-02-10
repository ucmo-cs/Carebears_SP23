package com.petvax.vaccinations.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccinations", schema = "PETVAX")
public class VaccinationEntity {
    @Id
    private Integer id;
    private String name;
    private String type;

    @Override
    public String toString() {
        return "VaccinationEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
