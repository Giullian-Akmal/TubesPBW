package com.example.tubesPBW.Controller;

import com.example.tubesPBW.Data.Member;
import com.example.tubesPBW.Repo.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PelangganRepository pelangganRepository;

    @GetMapping("/login.html")
    public String showLoginUser() {
        return "user/login";
    }

    @GetMapping("/signup.html")
    public String showSignupUser() {
        return "user/signup";
    }

    @GetMapping("/dashboard.html")
    public String showDashboardUser() {
        return "user/dashboard";
    }

    @GetMapping("/histori.html")
    public String showHistoriUser() {
        return "user/histori";
    }

    @GetMapping("/pinjam.html")
    public String showPinjamUser() {
        return "user/pinjam";
    }

    @GetMapping("/tambahpinjam.html")
    public String showTambahPinjamUser() {
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



