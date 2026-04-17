package com.example.HMS.services;

import com.example.HMS.models.Patient;
import com.example.HMS.repository.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class patientServices {
    @Autowired
    PatientRepo patientRepo;
    private static  final Logger logger = LoggerFactory.getLogger(patientServices.class);

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();

    }
    public Patient getPatientById(Long id){
        return (Patient) patientRepo.findById(id).orElse(null);
    }
    public Patient createPatient(Patient patient){
           patientRepo.save(patient);
           return patient;
    }
    public void deletePatient(Long id){
        patientRepo.deleteById(id);

    }
    public Patient updatePatient(Long id,Patient updatedpatient){
       Optional<Patient> existingPatient = patientRepo.findById(id);
       if(existingPatient.isPresent()){
           Patient p =existingPatient.get();
           p.setName(updatedpatient.getName());
           p.setAge(updatedpatient.getAge());
           p.setGender(updatedpatient.getGender());
           patientRepo.save(p);
           return p;

       }
       return null;
    }
    public Patient getPatientWithDetails(Long id){
        return patientRepo.findById(id).orElse(null);
    }


}
