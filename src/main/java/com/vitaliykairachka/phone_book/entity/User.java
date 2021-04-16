package com.vitaliykairachka.phone_book.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "{user.error.usernameRequired}")
    @Pattern(regexp = "[A-Za-z]+", message = "{user.error.usernameRegexp}")
    @Size(min = 3, message = "{user.error.usernameLength}")
    private String name;

    @Column(name = "surname")
    @Pattern(regexp = "[A-Za-z]+", message = "{user.error.usernameRegexp}")
    @Size(min = 3, message = "{user.error.usernameLength}")
    private String surname;

    @Column(name = "phone_number")
    @Pattern(regexp = "((8|\\+7)-?)?\\(?\\d{3}\\)?-?\\d{1}-?\\d{1}-?\\d{1}-?\\d{1}-?\\d{1}-?\\d{1}-?\\d{1}",
            message = "{contact.error.mobilePhoneRegexp}")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Contact> contacts;

    public void addContactToUser(Contact contact) {
        if (contacts == null) {
            contacts = new ArrayList<>();
        }
        contacts.add(contact);
        contact.setUser(this);
    }
}
