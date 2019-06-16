package pl.konopka.myfilmweb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.Comment;
import pl.konopka.myfilmweb.model.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmRepository {
    private List<Movie> movies;

    @Autowired
    public FilmRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie("Życie jest piękne", "Włoski film z 1997 roku w reżyserii Roberta Benigniego", "Dramat", 1997, "movie1.jpg", 1L));
        movies.add(new Movie("Rain Main", "Amerykański film fabularny z roku 1988 w reżyserii Barry’ego Levinsona.", "Dramat", 1988, "movie1.2pg", 2L));
        movies.add(new Movie("Dunkierka", "Amerykańsko–brytyjsko–francusko–holenderski film wojenny w reżyserii Christophera Nolana", "Wojenny", 2017, "movie1.jpg", 3L));


        Movie movie = new Movie("Życie jest piękne", "Włoski film z 1997 roku w reżyserii Roberta Benigniego", "Dramat", 1997, "movie2.jpg", 4L);
        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment("Jan", "Zdecydowanie nie polecam", LocalDate.now(), movie));
        commentList.add(new Comment("Krzysztof", "Dla mnie super", LocalDate.now(), movie));
        movie.setComments(commentList);
        movies.add(movie);
    }

    public List<Movie> getAllFilms() {
        return movies;
    }

    public Movie findById(Long id) {
        Movie result = null;
        for (Movie film : movies)
            if (id.equals(film.getId()))
                result = film;
        return result;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
