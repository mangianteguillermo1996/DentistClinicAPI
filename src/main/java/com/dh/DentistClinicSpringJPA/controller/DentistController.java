package com.dh.DentistClinicSpringJPA.controller;

import com.dh.DentistClinicSpringJPA.entities.Dentist;
import com.dh.DentistClinicSpringJPA.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    //Crear de odontologo
    @PostMapping("/save")
    public Dentist save(@RequestBody Dentist dentist){
        return dentistService.save(dentist);
    }

    //Generar una lista de los odontologos
    @GetMapping("/all")
    public List<Dentist> findAll(){
        return dentistService.findAll();
    }

    //Buscar un odontologo por path
    @GetMapping("/id/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Integer id){
        Optional<Dentist> dentistWanted = dentistService.findById(id);
        if(dentistWanted.isPresent()){
            return ResponseEntity.ok(dentistWanted.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Actualizar un odontologo
    @PutMapping("/update")
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist){
        Optional<Dentist> dentistWanted = dentistService.findById(dentist.getId());
        if(dentistWanted.isPresent()){
            dentistService.update(dentist);
            return ResponseEntity.ok(dentistWanted.get());
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Eliminar un odontologo por path
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Optional<Dentist> dentistWanted = dentistService.findById(id);
        if(dentistWanted.isPresent()){
            dentistService.delete(id);
            return "Delete successfully";
        } else  {
            return "Delete failed";
        }
    }


}
