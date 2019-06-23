package pl.konopka.myfilmweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.konopka.myfilmweb.model.Logic;
import pl.konopka.myfilmweb.model.Movie;
import pl.konopka.myfilmweb.repository.FilmRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    private FilmRepository filmRepository;

    @Autowired
    public SearchController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam String movieName, Model model) {
        List<Movie> allMovies = filmRepository.findAll();

        List<Movie> foundMovies = allMovies
                .stream()
                .filter(movie -> (movie.getTitle().toLowerCase())
                        .contains(movieName.toLowerCase()))
                .collect(Collectors.toList());

        Logic logic = new Logic();
        model.addAttribute("foundMovies", logic.CutString(foundMovies));

        return "searchResult";
    }
}
