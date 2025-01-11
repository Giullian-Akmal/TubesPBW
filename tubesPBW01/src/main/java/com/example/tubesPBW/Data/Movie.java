package com.example.tubesPBW.Data;

public class Movie {
    private int id;
    private String nama;
    private String genre;
    private String aktor;

    // Constructor
    public Movie(int id, String nama,String genre, String aktor) {
        this.id = id;
        this.nama = nama;
        this.genre = genre;
        this.aktor = aktor;
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

    // Correct the method names
    public String getGenre() {  // Capitalized 'N' in 'getNama'
        return genre;
    }

    public void setGenre(String genre) {  // Capitalized 'N' in 'setNama'
        this.genre = genre;
    }

    // Correct the method names
    public String getAktor() {  // Capitalized 'N' in 'getNama'
        return aktor;
    }

    public void setAktor(String aktor) {  // Capitalized 'N' in 'setNama'
        this.aktor = aktor;
    }
    
}