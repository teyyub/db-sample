package org.example.repositories;

import org.example.entities.Contact;
import org.example.entities.Person;
import org.example.utils.DbUtils;

import java.beans.Transient;
import java.sql.*;
import java.util.List;

public class DbPersonRepoImpl implements PersonRepository{
    private   Connection connection;

    public DbPersonRepoImpl() {
    }

    public DbPersonRepoImpl(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    static String INSERT_USERS_SQL = "insert into public.person(fin,name,surname,created) values(?,?,?,?)";

    @Override
    public List<Person> findAll() {
        return List.of();
    }

//    @Transaction
    @Override
    public void addPerson(Person person) {
        try (
//                Connection connection = DbUtils.getConn();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, person.getFin());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                     person.setId(generatedKeys.getLong(1)); // Return generated ID
                } else {
                    throw new SQLException("Failed to retrieve person ID.");
                }
            }
            List<Contact> c = person.getContacts();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person findPersonById(long id) {
        return null;
    }

    @Override
    public void updatePerson(long id, Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }
}
