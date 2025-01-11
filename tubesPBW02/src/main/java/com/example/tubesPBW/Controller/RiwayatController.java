package com.example.tubesPBW.Controller;

import com.example.tubesPBW.model.Peminjaman;
import com.example.tubesPBW.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RiwayatController {

    private final PeminjamanRepository peminjamanRepository;

    @Autowired
    public RiwayatController(PeminjamanRepository peminjamanRepository) {
        this.peminjamanRepository = peminjamanRepository;
    }

    @GetMapping("/histori.html")
    public String showRiwayatPeminjaman(@RequestParam("userId") int userId, Model model) {
        List<Peminjaman> riwayatPeminjaman = peminjamanRepository.findByUserId(userId);
        model.addAttribute("riwayatPeminjaman", riwayatPeminjaman);
        return "user/histori.html";
    }
}
