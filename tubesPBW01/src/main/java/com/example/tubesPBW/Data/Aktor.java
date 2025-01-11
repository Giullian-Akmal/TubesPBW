package com.example.tubesPBW.Data;

public class Aktor {
    private int id;
    private String nama;

    // Constructor
    public Aktor(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Correct the method names
    public String getNama() {  // Capitalized 'N' in 'getNama'
        return nama;
    }

    public void setNama(String nama) {  // Capitalized 'N' in 'setNama'
        this.nama = nama;
    }
}