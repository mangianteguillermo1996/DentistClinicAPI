package com.dh.DentistClinicSpringJPA.controller;

import com.dh.DentistClinicSpringJPA.entities.Patient;
import com.dh.DentistClinicSpringJPA.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //Crear un paciente
    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    //Generar una lista de los pacientes
    @GetMapping("/all")
    public List<Patient> findAll(){
        return patientService.findAll();
    }

    //Actualizar un paciente
    @PutMapping("/update")
    public ResponseEntity<Patient> update(@RequestBody Patient patient){
        Optional<Patient> patientWanted = patientService.findById(patient.getId());
        if(patientWanted.isPresent()){
            patientService.update(patient);
            return ResponseEntity.ok(patientWanted.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Buscar un paciente por parametro
    @GetMapping("/id")
    public ResponseEntity<Patient> findById(@RequestParam Integer id){
        Optional<Patient> patientWanted = patientService.findById(id);
        if(patientWanted.isPresent()){
            return ResponseEntity.ok(patientWanted.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Eliminar un paciente por path
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Patient> patientWanted = patientService.findById(id);
        if(patientWanted.isPresent()){
            patientService.delete(id);
            return "Delete successfully";
        } else {
            return "Delete failed";
        }
    }

    //Consultar paciente por apellido
    @GetMapping("/lastname/{lastName}")
    public Patient findByLastName(@PathVariable String lastName){
        Optional<Patient> patientWanted = patientService.findByLastName(lastName);
        if(patientWanted.isPresent()){
            return patientWanted.get();
        } else  {
            return null;
        }
    }

    //Consultar paciente por nombre
    @GetMapping("/firstname/{firstnName}")
    public Patient findByFirstName(@PathVariable String firstnName){
        Optional<Patient> patientWanted = patientService.findByFirstName(firstnName);
        if(patientWanted.isPresent()){
            return patientWanted.get();
        }  else  {
            return null;
        }
    }

}
