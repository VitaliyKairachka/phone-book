package com.vitaliykairachka.phone_book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
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

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_user", updatable = false, nullable = false)
    private User user;
}
