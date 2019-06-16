package pl.konopka.myfilmweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.konopka.myfilmweb.model.Movie;
import pl.konopka.myfilmweb.repository.FilmRepository;

@Controller
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/film")
    public String filmDetails(@RequestParam Long id, Model model) {
        Movie movie = filmRepository.findById(id);
        model.addAttribute("movie", movie);
        return "film";
    }
}
