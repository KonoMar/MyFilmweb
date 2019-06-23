package pl.konopka.myfilmweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.konopka.myfilmweb.model.User;
import pl.konopka.myfilmweb.repository.UserRepository;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addUser")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registrationform";
    }

    @PostMapping("/addUser")
    public String registration(User user, Model model){
        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 == null){
            user.setEnabled(true);
            user.setRole("ROLE_USER");
            userRepository.save(user);
            model.addAttribute("title", "Dodanie użytkownika:");
            model.addAttribute("message", "Użytkownik dodany poprawnie." );
            model.addAttribute("link", "/");
            return "/message";
        }
        else {
            model.addAttribute("title", "ERROR!!!!!!!!!!!!!!!");
            model.addAttribute("message", "Nazwa użytkownika istnieje" );
            model.addAttribute("link", "/registration/adduser");
            return "/message";
        }
    }
}
