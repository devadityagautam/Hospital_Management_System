package com.example.HMS.services;

import com.example.HMS.models.Bill;
import com.example.HMS.models.Patient;
import com.example.HMS.repository.BillRepo;
import com.example.HMS.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class billServices {
    @Autowired
    BillRepo billRepo;
    @Autowired
    PatientRepo patientRepo;

    public List<Bill> getAllBills(){
        return billRepo.findAll();
    }
    public Bill getBillById(Long id){
        return (Bill) billRepo.findById(id).orElse(null);

    }
    public Bill createBill(Bill bill){
        Long patientId =  bill.getPatient().getId();
        Patient patient = (Patient) patientRepo.findById(patientId).orElse(null);
        if(patient != null){
             bill.setPatient(patient);
             return (Bill) billRepo.save(bill);
        }
            return null;
    }
    public void deleteBill(Long id){
        billRepo.deleteById(id);

    }
    public Bill updateBill(Long id,Bill updatedBill){
        Bill existing = (Bill) billRepo.findById(id).orElse(null);

        if(existing != null){

            existing.setAmount(updatedBill.getAmount());

            // update patient if provided
            if(updatedBill.getPatient() != null){
                Long patientId = updatedBill.getPatient().getId();
                Patient patient = (Patient) patientRepo.findById(patientId).orElse(null);
                existing.setPatient(patient);
            }

            return (Bill) billRepo.save(existing);
        }

        return null;
    }

    }

