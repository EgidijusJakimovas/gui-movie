package org.example.gui.model;

import java.sql.*;
import java.util.ArrayList;

public class MovieDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/movie";
    private static String query;

    public static ArrayList<Movie> searchByName(String movieName, String role) {
        if (role.equals("admin")) {
            query = "SELECT * FROM movies WHERE name LIKE ?";
        } else {
            int userID = UserDAO.searchByUsernameReturnID(UserSingleton.getInstance().getUsername());
            query = "SELECT * FROM movies WHERE name LIKE ? AND user_id = " + userID;
        }
        ArrayList<Movie> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + movieName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("duration"),
                        resultSet.getString("actors"),
                        resultSet.getString("directors"),
                        resultSet.getInt("release_year"),
                        resultSet.getInt("user_id")
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
        query = "INSERT INTO movies (name, duration, actors, directors, release_year, user_id)\n" +
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
        query = "UPDATE movies SET name = ?, duration = ?, actors = ?, directors = ?, release_year = ?\n" +
                "WHERE id = ?;";
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
        query = "DELETE FROM movies WHERE id = ?;";
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
        query = "SELECT id FROM movies;";
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getInt("id"));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("There was an error deleting your item. More: " + e.getMessage());
        }
        return list;
    }
}
