package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.repository.ContactRepository;
import com.vitaliykairachka.phone_book.entity.Contact;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplementation implements ContactService {
    private final ContactRepository contactRepository;

    public ContactServiceImplementation(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllUserContacts(int id) {
        return contactRepository.findAllUserContacts(id);
    }

    @Override
    public Contact getPhoneNumber(String number) {
        return contactRepository.findContactByPhoneNumber(number);
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
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
}
