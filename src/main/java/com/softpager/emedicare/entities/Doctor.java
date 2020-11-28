package com.softpager.emedicare.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softpager.emedicare.abstracts.AbstractUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
@EqualsAndHashCode(callSuper = true)
public class Doctor extends AbstractUser{

    @Column(name = "speciality")
    private String speciality;


   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Doctor(String firstName, String lastName, Blob profilePhoto,
                  String userRole,String speciality) {
        super(firstName, lastName, profilePhoto, userRole);
        this.speciality = speciality;
    }

    public Doctor() { }

}
