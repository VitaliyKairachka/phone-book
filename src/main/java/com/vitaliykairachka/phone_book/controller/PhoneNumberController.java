package com.vitaliykairachka.phone_book.controller;

import com.vitaliykairachka.phone_book.entity.PhoneNumber;
import com.vitaliykairachka.phone_book.entity.User;
import com.vitaliykairachka.phone_book.service.PhoneNumberService;
import com.vitaliykairachka.phone_book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PhoneNumberController {
    @Autowired
    private PhoneNumberService phoneNumberService;

    @Autowired
    private UserService userService;

    @GetMapping("/number/user/{id}")
    public List<PhoneNumber> showAllNumbersOfUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return user.getUserNumbers();
    }

    @GetMapping("/number/{id}")
    public PhoneNumber getPhoneNumber(@PathVariable int id) {
        return phoneNumberService.getNumber(id);
    }

    @PostMapping("/number/user/{id}")
    public PhoneNumber addNewNumber(@RequestBody PhoneNumber phoneNumber, @PathVariable int id) {
        User user = userService.getUser(id);
        user.addNumberToUser(phoneNumber);
        userService.saveUser(user);
        return phoneNumber;
    }

    @PutMapping("/number")
    public PhoneNumber updatePhoneNumber(@RequestBody PhoneNumber phoneNumber) {
        PhoneNumber phoneNumber1 = null;
        if (phoneNumber != null) {
            phoneNumber1 = phoneNumberService.getNumber(phoneNumber.getId());
            phoneNumber1.setName(phoneNumber.getName());
            phoneNumber1.setSurname(phoneNumber.getSurname());
            phoneNumber1.setPhoneNumber(phoneNumber.getPhoneNumber());
        }
        phoneNumberService.saveNumber(phoneNumber1);
        return phoneNumber1;
    }

    @DeleteMapping("/number/{id}")
    public String deletePhoneNumber(@PathVariable int id) {
        phoneNumberService.deleteNumber(id);
        return "Number with ID = " + id + " was deleted";
    }
}
