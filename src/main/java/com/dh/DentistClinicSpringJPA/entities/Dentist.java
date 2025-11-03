package com.dh.DentistClinicSpringJPA.entities;

import jakarta.persistence.*;

@Entity
@Table(name="dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private Integer id;

    @Column(name = "registration_id", nullable = false, unique = true)
    private Integer registrationId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    public Dentist() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
