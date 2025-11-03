package com.dh.DentistClinicSpringJPA.repository;

import com.dh.DentistClinicSpringJPA.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query("SELECT p FROM Patient p WHERE p.lastName=?1")
    Optional<Patient> findByLastName(String lastName);

    Optional<Patient> findByFirstName(String firstName);

}
