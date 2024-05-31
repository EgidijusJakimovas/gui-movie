package org.example.gui.model;

import java.sql.*;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/movie";
    private static String query;

    public static void create(User user) {
        query = "INSERT INTO users (username, password, email, admin)\n" +
                "VALUES (?, ?, ?, ?);";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isAdmin());
            preparedStatement.executeUpdate();
            System.out.println("User successfully created");
        } catch (SQLException e) {
            System.out.println("Failed to create user: "
                    + e.getMessage());
        }
    }

    public static String getBCryptPassword(String username) {
        query = "SELECT password FROM users WHERE username = ?;";

        String passwordBCrypt = "";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                passwordBCrypt = resultSet.getString("password");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("There was an error searching for data. More: " +
                    e.getMessage());
        }
        return passwordBCrypt;
    }

    public static String searchByUsername(String username) {
        query = "SELECT * FROM users WHERE username = ?";

        String role = "";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                role = resultSet.getBoolean("admin") ? "admin" : "user";
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return role;
    }

    public static int searchByUsernameReturnID(String username) {
        query = "SELECT id FROM users WHERE username = ?";

        int userID = 0;
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userID = resultSet.getInt("id");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userID;
    }
}
