package com.example.tubesPBW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

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
}
