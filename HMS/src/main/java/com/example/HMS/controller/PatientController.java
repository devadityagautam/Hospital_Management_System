package com.example.HMS.controller;

import com.example.HMS.models.Patient;
import com.example.HMS.services.patientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    patientServices patientservices;

    @GetMapping
     public List<Patient> getAllPatients(){
        return patientservices.getAllPatients();

     }
     @PostMapping
     public Patient createPatient(@RequestBody Patient patient){
        return patientservices.createPatient(patient);
     }
     @GetMapping("/{id}")
     public Patient getPatientById(@PathVariable Long id){
        return patientservices.getPatientById(id);
     }
     @DeleteMapping("/{id}")
     public void deletePatient(@PathVariable Long id){
        patientservices.deletePatient(id);

     }
     @PutMapping("/{id}")
     public  void updatePatient(@PathVariable Long id,@RequestBody Patient patient){
            patientservices.updatePatient(id,patient);
     }
    @GetMapping("/{id}/details")
    public Patient getPatientDetails(@PathVariable Long id){
        return patientservices.getPatientWithDetails(id);
    }

}
