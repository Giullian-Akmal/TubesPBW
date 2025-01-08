package com.example.tubesPBW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login.html")
    public String showLoginAdmin() {
        return "admin/login";
    }

    @GetMapping("/dashboard.html")
    public String showDashboardAdmin() {
        return "admin/dashboard";
    }

    @GetMapping("/tambahaktor.html")
    public String showTambahAktorAdmin() {
        return "admin/tambahaktor";
    }

    @GetMapping("/tambahgenre.html")
    public String showTambahGenreAdmin() {
        return "admin/tambahgenre";
    }

    @GetMapping("/aktor.html")
    public String showAktorAdmin() {
        return "admin/aktor";
    }

    @GetMapping("/genre.html")
    public String showGenreAdmin() {
        return "admin/genre";
    }

    @GetMapping("/tambahfilm.html")
    public String showTambahFilmAdmin() {
        return "admin/tambahfilm";
    }
}