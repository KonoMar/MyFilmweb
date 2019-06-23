package pl.konopka.myfilmweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.konopka.myfilmweb.repository.FilmRepository;

@Controller
public class HomeController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/")
    public String filmDetails() {
        return "homePage";
    }
}

