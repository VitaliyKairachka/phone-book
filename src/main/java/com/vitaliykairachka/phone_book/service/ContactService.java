package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllUserContacts(int id);

    Contact getPhoneNumber(String number);

    Contact getContactById(int id);

    Contact updateContact(Contact contact);

    void deleteContact(int id);
}
