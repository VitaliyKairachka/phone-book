package com.vitaliykairachka.phone_book.repository;

import com.vitaliykairachka.phone_book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}