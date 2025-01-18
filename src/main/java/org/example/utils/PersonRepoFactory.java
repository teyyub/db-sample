package org.example.utils;

import org.example.repositories.DbPersonRepoImpl;
import org.example.repositories.PersonRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class PersonRepoFactory {
    public DbPersonRepoImpl createPersonRepo() throws Exception {
        // Read the implementation class name from the properties file
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new IOException("Property file 'config.properties' not found in the classpath.");
            }
            properties.load(inputStream);
        }
//        properties.load(new FileInputStream("application.properties"));
        String personRepoImplClassName = properties.getProperty("personRepo.impl");

        // Dynamically load the class using reflection
        Class<?> clazz = Class.forName(personRepoImplClassName);
//        Constructor<?> constructor = clazz.getConstructor(Connection.class);
        return (DbPersonRepoImpl) clazz.getConstructor().newInstance();
    }


}
