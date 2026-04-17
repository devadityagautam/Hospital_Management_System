package com.example.HMS.services;

import com.example.HMS.models.Doctor;
import com.example.HMS.models.Patient;
import com.example.HMS.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class doctorServices {
    @Autowired
    DoctorRepo doctorRepo;


    public List<Doctor> getAllDoctors(){
        return doctorRepo.findAll();
    }
    public Doctor getDoctorById(Long id){
        return (Doctor) doctorRepo.findById(id).orElse(null);
    }
    public Doctor createDoctor(Doctor doctor){
        return (Doctor) doctorRepo.save(doctor);

    }
    public void deleteDoctor(Long id){
        doctorRepo.deleteById(id);

    }
    public Doctor updateDoctor(Long id,Doctor updatedDoctor){
            Doctor existing = (Doctor) doctorRepo.findById(id).orElse(null);
            if(existing != null){
                existing.setName(updatedDoctor.getName());
                existing.setSpeciality(updatedDoctor.getSpeciality());
                return (Doctor) doctorRepo.save(existing);
            }
            return null;

    }

}
