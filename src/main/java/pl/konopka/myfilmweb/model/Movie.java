package pl.konopka.myfilmweb.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private String category;
    private int year;
    private String photo;
    private Long id = 0L;
    private List<Comment> comments = new ArrayList<>();

    public Movie(String title, String description, String category, int year, String photo, Long id) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.year = year;
        this.photo = photo;
        this.id = id;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", photo='" + photo + '\'' +
                ", id=" + id +
                ", comments=" + comments +
                '}';
    }
}
