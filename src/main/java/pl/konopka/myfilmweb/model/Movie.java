package pl.konopka.myfilmweb.model;

public class Movie {

    private Long id;
    private String title;
    private String description;
    private String category;
    private int year;
    private String photo;


    public Movie(Long id, String title, String description, String category, int year, String photo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.year = year;
        this.photo = photo;
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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", photo='" + photo + '\'' +
                '}';
    }
}
