package org.example.gui.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]{5,13}$";
    public static final String PASSWORD_REGEX_PATTERN = "^[A-Za-z0-9!-%]{5,13}$";
    public static final String EMAIL_REGEX_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
    public static final String MOVIE_ID_REGEX_PATTERN = "^[0-9]{1,55}$";
    public static final String MOVIE_DURATION_REGEX_PATTERN = "^[0-9]{1,100000}$";
    public static final String MOVIE_NAME_REGEX_PATTERN = "^[A-Za-z0-9!@#$%^&*,.;:\"\\s+]{1,255}$";

    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean isValidMovieName(String movieName) {
        Pattern pattern = Pattern.compile(MOVIE_NAME_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(movieName);
        return !matcher.matches();
    }

    public static boolean isValidMovieDuration(String movieDuration) {
        Pattern pattern = Pattern.compile(MOVIE_DURATION_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(movieDuration);
        return !matcher.matches();
    }

    public static boolean isValidMovieID(String movieID) {
        Pattern pattern = Pattern.compile(MOVIE_ID_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(movieID);
        return !matcher.matches();
    }

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
