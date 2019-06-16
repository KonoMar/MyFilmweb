package pl.konopka.myfilmweb.model;

public enum Category {
    THRILLER("Thriller"),
    HORROR("Horror"),
    DRAMA("Dramat"),
    SCIENCE_FICTION("Science fiction"),
    COMEDY("Komedia");

    private String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

