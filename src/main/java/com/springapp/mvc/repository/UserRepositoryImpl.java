package com.springapp.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zenet_000 on 8/24/2015.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(){

    }
    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<UserTO> getUsers() {
        final String sql = "SELECT * FROM \"user\"";
        final List<UserTO> listWithUsers = jdbcTemplate.query(sql, new RowMapper<UserTO>() {
            @Override
            public UserTO mapRow(ResultSet resultSet, int i) throws SQLException {
                UserTO user = new UserTO();
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                return user;
            }
        });
        return listWithUsers;
    }
}
