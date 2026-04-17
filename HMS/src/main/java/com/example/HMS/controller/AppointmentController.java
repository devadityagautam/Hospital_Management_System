package com.example.HMS.controller;

import com.example.HMS.models.Appointment;
import com.example.HMS.models.Patient;
import com.example.HMS.services.appointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    appointmentServices appointmentservices;
    @GetMapping
    public List<Appointment> getAllAppointment(){
        return appointmentservices.getAllAppointments();

    }
    @PostMapping
    public Appointment createAppointmment(@RequestBody Appointment appointment){
        return appointmentservices.createAppointment(appointment);
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentservices.getAppointmentById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteappointment(@PathVariable Long id){
                appointmentservices.deleteAppointment(id);
    }
    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment){
         appointmentservices.updateAppointment(id,appointment);

    }
}
