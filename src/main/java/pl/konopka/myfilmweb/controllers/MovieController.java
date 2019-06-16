package pl.konopka.myfilmweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.konopka.myfilmweb.model.Category;
import pl.konopka.myfilmweb.model.Movie;
import pl.konopka.myfilmweb.repository.FilmRepository;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private FilmRepository filmRepository;

    private Category category;

    @GetMapping("/addmovieform")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movieinputform";
    }

    @PostMapping("/addmovie")
    @ResponseBody
    public String addMovie(Movie movie) {
        List<Movie> movieList = filmRepository.getAllFilms();
        long maxId = 0;
        for (Movie movies : movieList) {
            if (movies.getId() > (int) maxId) {
                maxId = movies.getId();
            }
        }
        movie.setId(maxId + 1);
        filmRepository.addMovie(movie);

        return movie.toString() + "<br/> został dodany"; //tymczasowo
    }
}
