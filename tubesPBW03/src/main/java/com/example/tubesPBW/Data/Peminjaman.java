//kelas Peminjaman untuk menyimpan data transaksi peminjaman

package com.example.tubesPBW.Data;

public class Peminjaman {
    private int peminjamanId;
    private int userId;
    private int movieId;
    private String tanggalPinjam;
    private String tanggalKembali;

    //Getter dan Setter
    public int getPeminjamanId(){
        return peminjamanId;
    }

    public void setPeminjamanId(int peminjamanId){
        this.peminjamanId = peminjamanId;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int movieId(){
        return movieId;
    }

    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    public String getTanggalPinjam(){
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam){
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali(){
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali){
        this.tanggalKembali = tanggalKembali;
    }
}
