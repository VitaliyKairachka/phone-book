package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.entity.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> findAllUserContacts(int id);

    void saveContact(Contact contact);

    Contact getContactById(int id);

    Contact updateContact(Contact contact);

    void deleteContact(int id);
}
