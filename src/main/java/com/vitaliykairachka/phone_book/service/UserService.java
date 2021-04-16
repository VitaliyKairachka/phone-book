package com.vitaliykairachka.phone_book.service;

import com.vitaliykairachka.phone_book.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(int id);

    List<User> getAllUsersByName(String name);

    void updateUser(User user);

    void deleteUser(int id);
}
