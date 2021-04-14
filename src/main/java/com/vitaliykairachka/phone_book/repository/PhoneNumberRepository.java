package com.vitaliykairachka.phone_book.repository;

import com.vitaliykairachka.phone_book.entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {

}
