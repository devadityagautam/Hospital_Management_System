package com.example.HMS.controller;

import com.example.HMS.models.Bill;
import com.example.HMS.models.Patient;
import com.example.HMS.services.billServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    billServices billservices;

    @GetMapping
    public List<Bill> getAllbills(){
        return billservices.getAllBills();

    }
    @PostMapping
    public Bill createBill(@RequestBody Bill bill){
        return billservices.createBill(bill);
    }
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id){
        return billservices.getBillById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id){
        billservices.deleteBill(id);

    }
    @PutMapping("/{id}")
    public void updateBill(@PathVariable Long id,@RequestBody Bill bill){
            billservices.updateBill(id,bill);
    }

}
