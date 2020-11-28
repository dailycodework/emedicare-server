package com.softpager.emedicare.services;

import com.softpager.emedicare.abstracts.AbstractUser;
import com.softpager.emedicare.dao.IGenericDao;
import com.softpager.emedicare.entities.Account;
import com.softpager.emedicare.entities.Doctor;
import com.softpager.emedicare.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service("doctorService")
public class DoctorService implements IDoctorService {

    private IGenericDao<Doctor> doctor;
    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setDoctor(IGenericDao<Doctor> doctor) {
        this.doctor = doctor;
       this.doctor.setClazz(Doctor.class);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctor.getAll();
    }

    @Override
    public Optional<Doctor> getDoctor(long id) {
        return doctor.getOne(id);
    }

    @Override
    public void delete(long id) {
        Optional<Doctor> theDoctor = this.getDoctor(id);
        if (theDoctor.isPresent()){
            doctor.delete(id);
             }else{
            throw new ResourceNotFoundException("A Doctor with id : " +id+ " can not be found.");        }
    }

    @Override
    public long countDoctors() {
        return doctor.countAll();
    }

    @Override
    @Transactional
    public Object addDoctor(Doctor theDoctor) {
        Object createdDoctor =  doctor.addNew(theDoctor);
        Account userAccount = theDoctor.getAccount();
        userAccount.setUser(theDoctor);
        return accountService.create(userAccount);
    }
}
