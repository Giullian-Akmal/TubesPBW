package com.example.tubesPBW.Data;

public class Genre {
    private int id;
    private String nama;

    // Constructor
    public Genre(int id, String nama) {
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
    public String getNama() { 
        return nama;
    }

    public void setNama(String nama) { 
        this.nama = nama;
    }
}