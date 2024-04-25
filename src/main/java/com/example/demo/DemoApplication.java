package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        try (Connection connection = DB.connect()) {
            System.out.println("Connected to the PostgreSQL database.");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM accounts");
            if(resultSet.next()) {
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getArray(1));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
