package org.example.repositories;

import org.example.dtos.Person;
import org.example.utils.DbUtils;

import java.sql.*;
import java.util.List;

public class DbPersonRepoImpl implements PersonRepository{

    static String INSERT_USERS_SQL = "insert into person(fin,name,surname,created) values(?,?,?,?)";

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public void addPerson(Person person) {
        try (Connection connection = DbUtils.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {


            preparedStatement.setString(1, person.getFin());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getSurname());
            preparedStatement.setDate(4, new Date(System.currentTimeMillis()));

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
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
