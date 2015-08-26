package com.springapp.mvc.repository;

import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
public interface UserRepository {
    List<UserTO> getUsers();

    List<TypeTO> getTypes();

    void addUser(String firstName, String lastName);

    void addContact(int userID, int typeID, String value);

    void deleteUser(int userID);

    void deleteContact(int contactID);
}
