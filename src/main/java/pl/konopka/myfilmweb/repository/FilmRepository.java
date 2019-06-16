package pl.konopka.myfilmweb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmRepository {
    public List<Movie> movies;

    @Autowired
    public FilmRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie(1L, "title1", "desc1", "komedia", 2001, "url12"));
        movies.add(new Movie(2L, "Avatar", "jkdskf", "SF", 2009, "bsdkbdsksd"));
    }

    public List<Movie> getAllFilms(){return movies;}

    public Movie findById(Long id) {
        Movie result = null;
        for (Movie film : movies)
            if (id.equals(film.getId()))
                result = film;
        return result;
    }
}
