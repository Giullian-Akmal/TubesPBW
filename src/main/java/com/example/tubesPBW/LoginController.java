package com.example.tubesPBW;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/userLogin")
    public String userLogin(){
        return "user/login";
    }

    @GetMapping("/adminLogin")
    public String adminLogin(){
        return "admin/login";
    }

    @GetMapping("/userDashboard")
    public String userDashboard(){
        return "user/dashboard";
    }

    @GetMapping("/adminDashboard")
    public String adminDashboard(){
        return "admin/dashboard";
    }
}
