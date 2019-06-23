package pl.konopka.myfilmweb.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.konopka.myfilmweb.model.*;
import pl.konopka.myfilmweb.repository.UserRepository;
import pl.konopka.myfilmweb.repository.CategoryRepository;
import pl.konopka.myfilmweb.repository.CommentRepository;
import pl.konopka.myfilmweb.repository.FilmRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class FilmController {

    private static final Resource IMAGES_DIRECTORY = new ClassPathResource("/static/images");

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String filmDetails(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Movie> page = filmRepository.findAll(pageable);
        List<Movie> allMovies = page.getContent();
        model.addAttribute("actualPageNumber", page.getNumber());
        model.addAttribute("maxPageNumber", page.getTotalPages());

        Logic log = new Logic();
        model.addAttribute("lista", log.CutString(allMovies));

        return "movies";
    }

    @GetMapping("/movie")
    public String filmDetails(@RequestParam Long id, Model model) {
        Movie movie = filmRepository.findOne(id);
        List<Comment> comments = commentRepository.findAllByMovieId(id);

        model.addAttribute("newComment", new Comment());
        model.addAttribute("comments", comments);
        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/addMovie")
    public String addMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addNewMovieForm";
    }

    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie,
                           @RequestParam String username,
                           Model model) {
        List<Movie> movieList = filmRepository.findAll();
        User userByUsername = userRepository.findByUsername(username);
        long maxId = 0;

        for (Movie movies : movieList) {
            if (movies.getId() > (int) maxId) {
                maxId = movies.getId();
            }
        }

        movie.setAuthor(userByUsername);
        movie.setId(maxId + 1);
        movie.setPhoto("anon.jpg");
        filmRepository.save(movie);

        return "redirect:/movies/movie?id=" + movie.getId();
    }

    @PostMapping("/movie/addComment")
    public String addComment(@ModelAttribute Comment comment,
                             @RequestParam(name = "userName", required = true) String userName,
                             @RequestParam(name = "movieId", required = true) Long movieId) {
        User user = userRepository.findByUsername(userName);
        Movie movie = filmRepository.findOne(movieId);

        user.getUsername();
        comment.setAuthor(user);
        comment.setMovie(movie);
        comment.setDate(new Date());

        commentRepository.save(comment);
        return "redirect:/movies/movie?id=" + movie.getId();
    }

    @GetMapping("/{id}/edit")
    public String editMovie(@PathVariable Long id, Model model) {
        Movie movie = filmRepository.findOne(id);
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    @PostMapping("/{id}/edit")
    public String postEditMovie(@ModelAttribute Movie movie, Model model) {
        filmRepository.save(movie);
        return "redirect:/movies/movie?id=" + movie.getId();
    }

    @PostMapping("/{id}/cover")
    public String postMovieCover(@PathVariable Long id, MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        if (!isImage(file)) {
            redirectAttributes.addFlashAttribute("error", "Niestety to nie jest obraz");
            return "redirect:/movies/" + id + "/edit";
        }

        File fileInImagesDir = copyCoverToImagesDir(id, file);

        Movie movie = filmRepository.findOne(id);
        deleteOldCoverAssociatedWithMovie(movie);

        movie.setPhoto(fileInImagesDir.getName());
        filmRepository.save(movie);

        return "redirect:/movies/" + id + "/edit";
    }

    private File copyCoverToImagesDir(@PathVariable Long id, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File tempFile = File.createTempFile("movie" + id, fileName.substring(fileName.lastIndexOf(".")),
                IMAGES_DIRECTORY.getFile());
        try (InputStream in = file.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }

    private boolean isImage(MultipartFile file) {
        return file.getContentType().startsWith("image");
    }

    private void deleteOldCoverAssociatedWithMovie(Movie movie) throws IOException {
        String photoName = movie.getPhoto();
        if (photoName != null) {
            ClassPathResource oldCover = new ClassPathResource("/static/images/" + photoName);
            Files.deleteIfExists(Paths.get(oldCover.getURI()));
        }
    }

    @ModelAttribute("allCategories")
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
