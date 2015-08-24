package com.springapp.mvc.repository;

import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
public class UserTO {
    private int id;
    private String firstName;
    private String lastName;
    private List<ContactTO> contacts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ContactTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactTO> contacts) {
        this.contacts = contacts;
    }
}
