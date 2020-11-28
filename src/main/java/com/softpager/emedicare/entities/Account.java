package com.softpager.emedicare.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.softpager.emedicare.abstracts.AbstractUser;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"createdAt","updatedAt"},allowGetters = true)
public class Account implements Serializable {

      @Id
      @GeneratedValue
      @Column(name = "account_id")
      private long id;

      @NaturalId
      @Embedded
      private Contact contact;
      private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated", nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private AbstractUser user;

    public Account(Contact contact, String password) {
        this.contact = contact;
        this.password = password;
    }

    public Account() {
    }

}
