package com.softpager.emedicare.entities;

import com.softpager.emedicare.abstracts.AbstractUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
@EqualsAndHashCode(callSuper = true)
public class Patient extends AbstractUser {

    @Column(name = "address")
    private Address address;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, Blob profilePhoto, String userRole,
                   Address address) {
        super(firstName, lastName, profilePhoto, userRole);
        this.address = address;
    }

    public Patient() {
    }
}
