package com.softpager.emedicare.controller;

import com.softpager.emedicare.entities.Doctor;
import com.softpager.emedicare.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    private DoctorService doctorService;
    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    
    @GetMapping()
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") long theId){
        return doctorService.getDoctor(theId);
    }

    @PostMapping()
    public void addNew(@RequestBody Doctor theDoctor){
        doctorService.addDoctor(theDoctor);
    }
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable("id")  long theId){

    }
}
