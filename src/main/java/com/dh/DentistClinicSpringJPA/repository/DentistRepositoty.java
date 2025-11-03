package com.dh.DentistClinicSpringJPA.repository;

import com.dh.DentistClinicSpringJPA.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepositoty extends JpaRepository<Dentist, Integer> {

}
