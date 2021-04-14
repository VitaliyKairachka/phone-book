package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.repository.PhoneNumberRepository;
import com.vitaliykairachka.phone_book.entity.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberServiceImplementation implements PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Override
    public void saveNumber(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }

    @Override
    public PhoneNumber getNumber(int id) {
        PhoneNumber phoneNumber = null;
        Optional<PhoneNumber> optional = phoneNumberRepository.findById(id);
        if (optional.isPresent()) {
            phoneNumber = optional.get();
        }
        return phoneNumber;
    }

    @Override
    public void deleteNumber(int id) {
        phoneNumberRepository.deleteById(id);
    }
}
