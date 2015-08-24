package com.springapp.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<UserTO> getUsers() {

        final List<UserTO> listWithUsers = new LinkedList<UserTO>();
        final UserTO user = new UserTO();
        user.setFirstName("Vasiliy");
        listWithUsers.add(user);
        return listWithUsers;
    }
}
