package com.springapp.mvc.repository;

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

    public UserRepositoryImpl() {

    }

    public UserRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<TypeTO> getTypes() {
        final String sqlGetTypes = "SELECT * FROM \"type\"";
        return jdbcTemplate.query(sqlGetTypes, new RowMapper<TypeTO>() {
            public TypeTO mapRow(ResultSet resultSet, int i) throws SQLException {
                TypeTO typeTO = new TypeTO();
                typeTO.setType(resultSet.getInt(1));
                typeTO.setValue(resultSet.getString(2));
                return typeTO;
            }
        });
    }

    public List<UserTO> getUsers() {
        final String sqlUsers = "SELECT * FROM \"user\"";
        final List<UserTO> listWithUsers = jdbcTemplate.query(sqlUsers, new RowMapper<UserTO>() {
            public UserTO mapRow(ResultSet resultSet, int i) throws SQLException {
                UserTO user = new UserTO();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                String sqlContacts = "SELECT *" +
                        "FROM \"contact\" AS c INNER JOIN \"type\" AS t ON t.id = c.\"type\" " +
                        "WHERE id_user = " + user.getId();
                List<ContactTO> listWithContacts = jdbcTemplate.query(sqlContacts, new RowMapper<ContactTO>() {

                    public ContactTO mapRow(ResultSet resultSet, int i) throws SQLException {
                        ContactTO contact = new ContactTO();
                        contact.setId(resultSet.getInt(1));
                        contact.setType(resultSet.getString(6));
                        contact.setValue(resultSet.getString(4));
                        return contact;
                    }
                });
                user.setContacts(listWithContacts);
                return user;
            }
        });
        return listWithUsers;
    }

    public void addUser(String firstName, String lastName) {
        final String sqlAddUser = "INSERT INTO \"user\" (first_name, last_name) VALUES (?, ?)";
        jdbcTemplate.update(sqlAddUser, firstName, lastName);
    }

    public void addContact(int userID, int typeID, String value) {
        final String sqlAddUser = "INSERT INTO \"contact\" (\"type\", id_user, value) VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlAddUser, typeID, userID, value);
    }

    public void deleteUser(int userID) {
        final String sqlDeleteContact = "DELETE FROM \"contact\" WHERE id_user = ?";
        jdbcTemplate.update(sqlDeleteContact, userID);
        final String sqlDeleteUser = "DELETE FROM \"user\" WHERE id = ?";
        jdbcTemplate.update(sqlDeleteUser, userID);
    }

    public void deleteContact(int contactID) {
        final String sqlDeleteContact = "DELETE FROM \"contact\" WHERE id = ?";
        jdbcTemplate.update(sqlDeleteContact, contactID);
    }
}
