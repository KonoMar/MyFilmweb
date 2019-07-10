package pl.konopka.myfilmweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.konopka.myfilmweb.model.Movie;

@Repository
public interface FilmRepository extends JpaRepository<Movie , Long> {
}
