package org.example.gui.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Movie {
    private int movieID;
    private String movieTitle;
    private int movieDuration;
    private String actors;
    private String directors;
    private int releaseYear;
    private int userID;

    public Movie(int movieID, String movieTitle, int movieDuration, String actors, String directors, int releaseYear) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieDuration = movieDuration;
        this.actors = actors;
        this.directors = directors;
        this.releaseYear = releaseYear;
    }

    public Movie(int movieID, String movieTitle, int movieDuration, String actors, String directors, int releaseYear, int userID) {
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieDuration = movieDuration;
        this.actors = actors;
        this.directors = directors;
        this.releaseYear = releaseYear;
        this.userID = userID;
    }

    public Movie(String movieTitle, int movieDuration, String actors, String directors, int releaseYear, int userID) {
        this.movieTitle = movieTitle;
        this.movieDuration = movieDuration;
        this.actors = actors;
        this.directors = directors;
        this.releaseYear = releaseYear;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID=" + movieID +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieDuration=" + movieDuration +
                ", actors='" + actors + '\'' +
                ", directors='" + directors + '\'' +
                ", releaseYear=" + releaseYear +
                ", userID=" + userID +
                '}';
    }
}
