package com.vitaliykairachka.phone_book.dao;

import com.vitaliykairachka.phone_book.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
