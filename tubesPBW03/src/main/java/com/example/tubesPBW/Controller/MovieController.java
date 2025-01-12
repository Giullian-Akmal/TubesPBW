/*package com.example.tubesPBW.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tubesPBW.Data.Movie;
import com.example.tubesPBW.Data.Peminjaman;
import com.example.tubesPBW.Repo.MovieRepository;
import com.example.tubesPBW.Repo.PeminjamanRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieRepository.findAllMovies();
        model.addAttribute("movies", movies);
        return "user/movies"; // Thymeleaf file: user/movies.html
    }

    @GetMapping("/movies/search")
    public String searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String actor,
            Model model) {
        List<Movie> movies = movieRepository.searchFilms(title, genre, actor);
        model.addAttribute("movies", movies);
        return "user/movies"; // Thymeleaf file: user/movies.html
    }

    @GetMapping("/peminjaman")
    public String viewPeminjamanPage(@RequestParam("userId") int userId, Model model) {
        List<Peminjaman> peminjamanList = peminjamanRepository.findByUserId(userId);
        model.addAttribute("peminjamanList", peminjamanList);
        return "user/peminjaman"; // Thymeleaf file: user/peminjaman.html
    }

    @PostMapping("/peminjaman/add")
    public String addPeminjaman(@RequestParam("userId") int userId,
                                @RequestParam("movieId") int movieId,
                                @RequestParam("lamaPeminjaman") int lamaPeminjaman,
                                Model model) {
        peminjamanRepository.addPeminjaman(userId, movieId, lamaPeminjaman);
        return "redirect:/peminjaman?userId=" + userId;
    }
}*/

package com.example.tubesPBW.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tubesPBW.Data.Movie;
import com.example.tubesPBW.Data.Peminjaman;
import com.example.tubesPBW.Repo.MovieRepository;
import com.example.tubesPBW.Repo.PeminjamanRepository;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        List<Movie> movies = movieRepository.findAll();  // Menggunakan findAll() yang sudah diubah
        model.addAttribute("movies", movies);
        return "user/movies";  // Thymeleaf file: user/movies.html
    }

    @GetMapping("/movies/search")
    public String searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) String actor,
            Model model) {
        List<Movie> movies = movieRepository.searchFilms(title, genre, actor);  // Menggunakan searchFilms()
        model.addAttribute("movies", movies);
        return "user/movies";  // Thymeleaf file: user/movies.html
    }

    @GetMapping("/peminjaman")
    public String viewPeminjamanPage(@RequestParam("userId") int userId, Model model) {
        List<Peminjaman> peminjamanList = peminjamanRepository.findByUserId(userId);
        model.addAttribute("peminjamanList", peminjamanList);
        return "user/peminjaman";  // Thymeleaf file: user/peminjaman.html
    }

    @PostMapping("/peminjaman/add")
    public String addPeminjaman(@RequestParam("userId") int userId,
                                @RequestParam("movieId") int movieId,
                                @RequestParam("lamaPeminjaman") int lamaPeminjaman,
                                Model model) {
        peminjamanRepository.addPeminjaman(userId, movieId, lamaPeminjaman);
        return "redirect:/peminjaman?userId=" + userId;
    }
}
