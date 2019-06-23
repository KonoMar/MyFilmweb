package pl.konopka.myfilmweb.model;

import java.util.ArrayList;
import java.util.List;

public class Logic {

    public List<Movie> CutString(List<Movie> allMovies) {
        List<Movie> allMoviepom = new ArrayList<>();
        for (Movie allMovie : allMovies) {
            Movie mov = allMovie;
            if (mov.getDescription().length() <= 30) {
                mov.setDescription(mov.getDescription().substring(0, mov.getDescription().length()));
            } else {
                mov.setDescription(mov.getDescription().substring(0, 30));
            }
            allMoviepom.add(mov);
        }
        return allMoviepom;
    }
}
