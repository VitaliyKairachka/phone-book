package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.repository.ContactRepository;
import com.vitaliykairachka.phone_book.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> findAllUserContacts(int id) {
        return contactRepository.findAllUserContacts(id);
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveAndFlush(contact);
    }


    @Override
    public Contact getContactById(int id) {
        Contact contact = null;
        Optional<Contact> optional = contactRepository.findById(id);
        if (optional.isPresent()) {
            contact = optional.get();
        }
        return contact;
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
}
