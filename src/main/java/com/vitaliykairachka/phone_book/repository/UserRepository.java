package com.vitaliykairachka.phone_book.repository;

import com.vitaliykairachka.phone_book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select p from User p where p.name like %:name")
    List<User> findUsersByNameContaining(@Param("name") String name);
}
