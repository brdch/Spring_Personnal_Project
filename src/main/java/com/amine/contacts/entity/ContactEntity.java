package com.amine.contacts.entity;

import javax.persistence.*;

@Entity
public class ContactEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(length=50, nullable=false)
    private String name;

    @Column( length=50, nullable=false)
    private String email;

    @Column( length=50, nullable=false)
    private String phone;

    @Column(length=50, nullable=false)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
