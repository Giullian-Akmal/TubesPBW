package com.example.tubesPBW.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.tubesPBW.Data.Aktor;
import com.example.tubesPBW.Data.Genre;
import com.example.tubesPBW.Data.Movie;
import com.example.tubesPBW.Repo.AdminRepository;
import com.example.tubesPBW.Repo.AktorRepository;
import com.example.tubesPBW.Repo.GenreRepository;
import com.example.tubesPBW.Repo.MovieRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AktorRepository aktorRepository;
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/login.html")
    public String showMemberPage(Model model) {
        return "admin/login";
    }
    @GetMapping("/login-submit")
    public String showlogPage(Model model) {
        return "admin/login";
    }

    @PostMapping("/login-submit")
    public String showLoginAdmin(@RequestParam String email, @RequestParam String password, Model model) {
        // Gunakan metode isValidAdmin untuk memeriksa username dan password di database
        if (adminRepository.isValidAdmin(email, password)) {
            List<Movie> movies = movieRepository.findAll(); // Ambil data member
            model.addAttribute("movies", movies);
            return "admin/dashboard"; // Login berhasil
        }

        // Jika login gagal, tambahkan pesan error ke model
        model.addAttribute("error", "Username atau password salah!");
        return "admin/login"; // Kembali ke halaman login jika gagal
    }

    @GetMapping("/dashboard.html")
    public String showDashboardAdmin(Model model) {
        List<Movie> movies = movieRepository.findAll(); // Ambil data member
        model.addAttribute("movies", movies);
        return "admin/dashboard";
    }

    @GetMapping("/tambahaktor.html")
    public String showTambahAktorAdmin() {
        return "admin/tambahaktor";
    }

    @GetMapping("/tambah-aktor")
        public String TambahaktorAdmin(){
        return "admin/tambahaktor";
    }

    @PostMapping("/tambah-aktor")
        public String TambahAktorAdmin(@RequestParam("namaAktor") String namaAktor,
                            RedirectAttributes redirectAttributes) {
        try {
            adminRepository.addAktor(namaAktor); // Simpan artis ke database
            redirectAttributes.addFlashAttribute("successMessage", "Artis berhasil ditambahkan!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambahkan artis: " + e.getMessage());
        }
        return "admin/tambahaktor";
    }

    @GetMapping("/tambahgenre.html")
        public String showTambahGenreAdmin(){
        return "admin/tambahgenre";
    }

    @GetMapping("/tambah-genre")
        public String TambahGenreAdmin(){
        return "admin/tambahgenre";
    }

    @PostMapping("/tambah-genre")
        public String TambahGenreAdmin(@RequestParam("namaGenre") String namaGenre,
                            RedirectAttributes redirectAttributes) {
        try {
            adminRepository.addGenre(namaGenre); // Simpan artis ke database
            redirectAttributes.addFlashAttribute("successMessage", "Artis berhasil ditambahkan!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambahkan artis: " + e.getMessage());
        }
        return "admin/tambahgenre";
    }

    @GetMapping("/aktor.html")
    public String showAktorAdmin(Model model) {
        List<Aktor> aktors = aktorRepository.findAll(); // Ambil data member
        model.addAttribute("aktors", aktors);
        return "admin/aktor";
    }

    @GetMapping("/genre.html")
    public String showGenreAdmin(Model model) {
        List<Genre> genres = genreRepository.findAll(); // Ambil data member
        model.addAttribute("genres", genres);
        return "admin/genre";
    }

    @GetMapping("/tambahfilm.html")
    public String showTambahFilmAdmin(Model model) {
        List<Aktor> aktors = aktorRepository.findAll(); // Ambil data member
        model.addAttribute("aktors", aktors);
        List<Genre> genres = genreRepository.findAll(); // Ambil data member
        model.addAttribute("genres", genres);
        return "admin/tambahfilm";
    }

    @GetMapping("/tambah-film")
        public String TambahfilmAdmin(Model model){
        List<Aktor> aktors = aktorRepository.findAll(); // Ambil data member
        model.addAttribute("aktors", aktors);
        List<Genre> genres = genreRepository.findAll(); // Ambil data member
        model.addAttribute("genres", genres);
        return "admin/tambahfilm";
    }

    @PostMapping("/tambah-film")

        public String TambahFilmAdmin(@RequestParam("namaFilm") String namaFilm,@RequestParam("aktor") String aktor,@RequestParam("genre") String genre,Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            adminRepository.addMovie(namaFilm,aktor,genre); // Simpan artis ke database
            redirectAttributes.addFlashAttribute("successMessage", "Artis berhasil ditambahkan!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambahkan artis: " + e.getMessage());
        }
        List<Aktor> aktors = aktorRepository.findAll(); // Ambil data member
        model.addAttribute("aktors", aktors);
        List<Genre> genres = genreRepository.findAll(); // Ambil data member
        model.addAttribute("genres", genres);
        return "admin/tambahfilm"; // Nama file HTML di folder templates tanpa ekstensi
    }
    
}