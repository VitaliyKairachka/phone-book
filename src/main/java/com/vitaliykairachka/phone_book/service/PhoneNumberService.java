package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.entity.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {
    public void saveNumber(PhoneNumber phoneNumber);

    public PhoneNumber getNumber(int id);

    public void deleteNumber(int id);
}
