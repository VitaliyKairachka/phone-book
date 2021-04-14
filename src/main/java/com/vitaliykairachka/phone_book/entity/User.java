package com.vitaliykairachka.phone_book.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PhoneNumber> phoneNumbers;

    public User() {
    }

    public User(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public void addNumberToUser(PhoneNumber phoneNumber) {
        if (phoneNumbers == null) {
            phoneNumbers = new ArrayList<>();
        }
        phoneNumbers.add(phoneNumber);
        phoneNumber.setUser(this);
    }

    public List<PhoneNumber> getUserNumbers() {
        return phoneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
