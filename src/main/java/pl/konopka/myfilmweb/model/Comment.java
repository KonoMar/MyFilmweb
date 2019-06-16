package pl.konopka.myfilmweb.model;

import java.time.LocalDate;

public class Comment {

    private String author;
    private String content;
    private LocalDate date;
    private Movie movie;

    public Comment(String author, String content, LocalDate date, Movie movie) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.movie = movie;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
