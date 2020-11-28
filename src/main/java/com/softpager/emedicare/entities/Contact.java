package com.softpager.emedicare.entities;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Contact {
    private String mobile;
    private String email;

    public Contact(String mobile, String email) {
        this.mobile = mobile;
        this.email = email;
    }

    public Contact() {
    }
}