package com.example.tubesPBW.Controller;

import com.example.tubesPBW.Data.Genre;
import com.example.tubesPBW.Data.Member;
import com.example.tubesPBW.Data.Movie;
import com.example.tubesPBW.Data.Peminjaman;
import com.example.tubesPBW.Repo.PelangganRepository;
import com.example.tubesPBW.Repo.PeminjamanRepository;
import com.example.tubesPBW.Repo.MovieRepository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private PeminjamanRepository peminjamanRepository;

   @GetMapping("/login.html")
    public String showMemberPage(Model model) {
        return "user/login";
    }
    @GetMapping("/login-submit")
    public String showlogPage(Model model) {
        return "user/login";
    }

    @PostMapping("/login-submit")
    public String showLoginAdmin(@RequestParam String email, @RequestParam String password, Model model) {
        // Gunakan metode isValidAdmin untuk memeriksa username dan password di database
        if (pelangganRepository.isValidUser(email, password)) {
            List<Movie> movies = movieRepository.findAll(); // Ambil data member
            model.addAttribute("movies", movies);
            return "user/dashboard"; // Login berhasil
        }

        // Jika login gagal, tambahkan pesan error ke model
        model.addAttribute("error", "Username atau password salah!");
        return "user/login"; // Kembali ke halaman login jika gagal
    }

    @GetMapping("/signup.html")
    public String showSignupUser() {
        return "user/signup";
    }

    @GetMapping("/sign-up")
        public String TambahaktorAdmin(){
        return "user/signup";
    }

    @PostMapping("/sign-up")
        public String TambahAktorAdmin(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("notelp") String notelp,Model model,
            RedirectAttributes redirectAttributes) {
        try {
            pelangganRepository.save(name,email,password,notelp); // Simpan artis ke database
            redirectAttributes.addFlashAttribute("successMessage", "Artis berhasil ditambahkan!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambahkan artis: " + e.getMessage());
        }
        return "user/signup";
    }

    @GetMapping("/dashboard.html")
    public String showDashboardUser(Model model) {
        List<Movie> movies = movieRepository.findAll(); // Ambil data member
        model.addAttribute("movies", movies);
        return "user/dashboard";
    }

    @GetMapping("/histori.html")
    public String showHistoriUser() {
        return "user/histori";
    }

    @GetMapping("/pinjam.html")
    public String showPinjamUser(Model model) {
        List<Peminjaman> Peminjaman = peminjamanRepository.findAll(); // Ambil data member
        model.addAttribute("Peminjaman", Peminjaman);
        return "user/pinjam";
    }

    @GetMapping("/tambahpinjam.html")
    public String showTambahPinjamUser(Model model) {
        List<Movie> movies = movieRepository.findAll(); // Ambil data member
        model.addAttribute("movies", movies);
        return "user/tambahpinjam";
    }

    @GetMapping("/tambah-pinjam")
        public String Tambahpinjam(Model model){
        List<Movie> movies = movieRepository.findAll(); // Ambil data member
        model.addAttribute("movies", movies);
        return "user/tambahpinjam";
    }

    @PostMapping("/tambah-pinjam")
        public String TambahAktorAdmin(@RequestParam("movie") String judulfilm, @RequestParam("durasi") String durasi,Model model,
                            RedirectAttributes redirectAttributes) {
        try {
            pelangganRepository.addpinjam(judulfilm,durasi); // Simpan artis ke database
            redirectAttributes.addFlashAttribute("successMessage", "Artis berhasil ditambahkan!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Gagal menambahkan artis: " + e.getMessage());
        }
        List<Movie> movies = movieRepository.findAll(); // Ambil data member
        model.addAttribute("movies", movies);
        return "user/tambahpinjam";
    }

    // Menangani login
    @GetMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Cek apakah email dan password cocok dengan data yang ada di database
        // Setelah itu arahkan ke halaman dashboard
        return "redirect:/user/dashboard.html";
    }
}



