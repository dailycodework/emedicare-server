package com.softpager.emedicare.services;

import com.softpager.emedicare.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    List<Doctor> getDoctors();
    Optional<Doctor> getDoctor(long id);
    void delete(long id);
    long countDoctors();
    Object addDoctor(Doctor theDoctor);
}
