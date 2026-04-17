package com.example.HMS.services;

import com.example.HMS.models.Appointment;
import com.example.HMS.models.Bill;
import com.example.HMS.models.Doctor;
import com.example.HMS.models.Patient;
import com.example.HMS.repository.AppointmentRepo;
import com.example.HMS.repository.DoctorRepo;
import com.example.HMS.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appointmentServices {
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    DoctorRepo doctorRepo;


    public List<Appointment> getAllAppointments(){
        return appointmentRepo.findAll();

    }
    public Appointment getAppointmentById(Long id){
            return (Appointment) appointmentRepo.findById(id).orElse(null);
    }
    public Appointment createAppointment(Appointment appointment){
        Long patientId= appointment.getPatient().getId();
        Patient patient = (Patient) patientRepo.findById(patientId).orElse(null);

        Long doctorId = appointment.getDoctor().getId();
        Doctor doctor = (Doctor) doctorRepo.findById(doctorId).orElse(null);

        if(patient != null && doctor != null){
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            return (Appointment) appointmentRepo.save(appointment);
        }

        return null;

    }
    public void deleteAppointment(Long id){
        appointmentRepo.deleteById(id);

    }
    public Appointment updateAppointment(Long id, Appointment updated){
        Appointment existing = (Appointment) appointmentRepo.findById(id).orElse(null);
        if(existing != null){
            if(updated.getPatient() != null){
                Long patientId = updated.getPatient().getId();
                Patient patient = (Patient) patientRepo.findById(patientId).orElse(null);
                existing.setPatient(patient);
            }
            if(updated.getDoctor() != null){
                Long doctorId = updated.getDoctor().getId();
                Doctor doctor = (Doctor) doctorRepo.findById(doctorId).orElse(null);
                existing.setDoctor(doctor);
            }

            return (Appointment) appointmentRepo.save(existing);
        }

        return null;
    }
}

