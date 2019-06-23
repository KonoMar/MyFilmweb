package pl.konopka.myfilmweb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int year;
    private String photo;

    @OneToMany(mappedBy = "movie")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    public Movie(String title, String description, Category category, int year, String photo, Set<Comment> comments) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.year = year;
        this.photo = photo;
        this.comments = comments;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Film nr: " + id + " Tytuł: " + title + " (" + year + "); opis: " + description + "; gatunek: " +
                category;
    }
}
