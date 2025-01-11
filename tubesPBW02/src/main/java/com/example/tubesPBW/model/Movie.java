package com.example.tubesPBW.model;

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
}
