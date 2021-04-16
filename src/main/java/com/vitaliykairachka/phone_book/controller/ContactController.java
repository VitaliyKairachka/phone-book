package com.vitaliykairachka.phone_book.controller;

import com.vitaliykairachka.phone_book.entity.Contact;
import com.vitaliykairachka.phone_book.entity.User;
import com.vitaliykairachka.phone_book.service.ContactService;
import com.vitaliykairachka.phone_book.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneBook")
public class ContactController {
    private final ContactService contactService;

    private final UserService userService;

    public ContactController(ContactService contactService, UserService userService) {
        this.contactService = contactService;
        this.userService = userService;
    }

    @GetMapping("/contact/user/{id}")
    public List<Contact> showAllContactsOfUser(@PathVariable int id) {
        return contactService.getAllUserContacts(id);
    }

    @GetMapping("/contact/{id}")
    public Contact getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/contact/number/{number}")
    public Contact getContactByPhoneNumber(@PathVariable String number) {
        return contactService.getPhoneNumber(number);
    }

    @PostMapping("/contact/user/{id}")
    public Contact addNewContact(@RequestBody Contact contact, @PathVariable int id) {
        User user = userService.getUserById(id);
        user.addContactToUser(contact);
        userService.saveUser(user);
        return contact;
    }

    @PutMapping("/contact")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/contact/{id}")
    public String deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
        return "Number with ID = " + id + " was deleted";
    }
}
