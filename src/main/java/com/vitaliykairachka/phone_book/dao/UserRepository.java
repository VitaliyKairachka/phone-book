package com.vitaliykairachka.phone_book.dao;

import com.vitaliykairachka.phone_book.entity.PhoneNumber;
import com.vitaliykairachka.phone_book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
}
