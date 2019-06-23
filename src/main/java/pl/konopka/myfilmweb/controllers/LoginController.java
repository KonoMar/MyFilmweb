package pl.konopka.myfilmweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/users/login")
    public String getLoginForm(){
        return "loginPage";
    }

}

