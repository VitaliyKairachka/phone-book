package com.vitaliykairachka.phone_book.repository;

import com.vitaliykairachka.phone_book.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select p from Contact p where p.user.id = :id_user")
    List<Contact> findAllUserContacts(@Param("id_user") int id);

    Contact findByPhoneNumber(String number);
}
