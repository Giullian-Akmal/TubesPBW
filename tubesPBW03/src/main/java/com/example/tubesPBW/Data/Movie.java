/*package com.example.tubesPBW.model;

public class Movie {
    private int MovieId;
    private String title;
    private String genre;
    private String actor;
    private String status;
    private int stock;
    private int harga;

    // Getters and Setters
    public int getId() {
        return MovieId;
    }

    public void setId(int MovieId) {
        this.MovieId = MovieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}*/

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
