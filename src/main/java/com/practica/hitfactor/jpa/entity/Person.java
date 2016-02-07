package com.practica.hitfactor.jpa.entity;

import com.practica.hitfactor.jpa.entity.common.AutoEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

/**
 * Person entity
 */
@Entity
@Table(name = "Persons")
public class Person extends AutoEntity {
    @Getter
    @Setter
    @Column(name = "firstName", nullable = false, length = 256)
    private String firstName;

    @Getter
    @Setter
    @Column(name = "lastName", nullable = false, length = 256)
    private String lastName;

    @Getter
    @Setter
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    @Getter
    @Setter
    @Column(name = "email", nullable = false, length = 256, unique = true)
    private String email;

    @Getter
    @Setter
    @Column(name = "phoneNumber", length = 16)
    private String phoneNumber;

    @Override
    public String toString() {
        return String.format("Person{id='%s';email='%s'}", getId(), getEmail());
    }
}
