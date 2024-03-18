package org.example.gui.model;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/movies";
    private static String query;

    public static ArrayList<Movie> searchByName(String movieName, String role) {
        if (role.equals("admin")) {
            query = "SELECT * FROM movies_data WHERE movieName LIKE ?";
        } else {
            int userID = UserDAO.searchByUsernameReturnID(UserSingleton.getInstance().getUsername());
            query = "SELECT * FROM movies_data WHERE movieName LIKE ? AND userID = " + userID;
        }
        ArrayList<Movie> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + movieName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Movie(
                        resultSet.getInt("movieID"),
                        resultSet.getString("movieName"),
                        resultSet.getInt("duration"),
                        resultSet.getString("actors"),
                        resultSet.getString("directors"),
                        resultSet.getInt("releaseYear"),
                        resultSet.getInt("userID")
                ));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void create(Movie movie) {
        query = "INSERT INTO movies_data (movieName, duration, actors, directors, releaseYear, userID)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movie.getMovieTitle());
            preparedStatement.setInt(2, movie.getMovieDuration());
            preparedStatement.setString(3, movie.getActors());
            preparedStatement.setString(4, movie.getDirectors());
            preparedStatement.setInt(5, movie.getReleaseYear());
            preparedStatement.setInt(6, movie.getUserID());
            preparedStatement.executeUpdate();
            System.out.println("Successfully created movie");
        } catch (SQLException e) {
            System.out.println("Failed to create movie: " + e.getMessage());
        }
    }

    public static void update(Movie movie) {
        query = "UPDATE movies_data SET movieName = ?, duration = ?, actors = ?, directors = ?, releaseYear = ?\n" +
                "WHERE movieID = ?;";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, movie.getMovieTitle());
            preparedStatement.setInt(2, movie.getMovieDuration());
            preparedStatement.setString(3, movie.getActors());
            preparedStatement.setString(4, movie.getDirectors());
            preparedStatement.setInt(5, movie.getReleaseYear());
            preparedStatement.setInt(6, movie.getMovieID());
            preparedStatement.executeUpdate();
            System.out.println("Successfully updated");
        } catch (SQLException e) {
            System.out.println("Failed to update: " + e.getMessage());
        }
    }

    public static void delete(int movieID) {
        query = "DELETE FROM movies_data WHERE movieID = ?;";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, movieID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Successfully deleted an item");
        } catch (SQLException e) {
            System.out.println("There was an error deleting your item. More: " + e.getMessage());
        }
    }

    public static ArrayList<Integer> getMovieIdNumbers() {
        query = "SELECT movieID FROM movies_data;";
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getInt("movieID"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("There was an error deleting your item. More: " + e.getMessage());
        }
        return list;
    }
}
