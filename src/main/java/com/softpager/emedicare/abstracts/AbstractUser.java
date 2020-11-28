package com.softpager.emedicare.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softpager.emedicare.entities.Account;
import com.softpager.emedicare.entities.Appointment;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public class AbstractUser implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Column(name = "photo")
    private Blob profilePhoto;

    @Column(name = "user_role")
    private String userRole;

    @OneToOne(mappedBy = "user")
    private Account account;

    public AbstractUser(String firstName, String lastName, Blob profilePhoto,
                        String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePhoto = profilePhoto;
        this.userRole = userRole;
    }


    public AbstractUser() {
    }


}
