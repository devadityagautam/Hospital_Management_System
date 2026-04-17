package com.example.HMS.controller;

import com.example.HMS.models.Doctor;
import com.example.HMS.models.Patient;
import com.example.HMS.services.doctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    doctorServices doctorservices;

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorservices.getAllDoctors();

    }
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorservices.createDoctor(doctor);
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        return doctorservices.getDoctorById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id){
        doctorservices.deleteDoctor(id);

    }
    @PutMapping("/{id}")
    public Doctor  updateDoctor(@PathVariable Long id,@RequestBody Doctor doctor){
            return doctorservices.updateDoctor(id,doctor);
    }

}
