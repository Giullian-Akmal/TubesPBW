//kelas Peminjaman untuk menyimpan data transaksi peminjaman

package com.example.tubesPBW.Data;

public class Peminjaman {
    private int peminjamanId;
    private String judulfilm;
    private int durasi;

    // Constructor
    public Peminjaman(int peminjamanId, String judulfilm,int durasi) {
        this.peminjamanId = peminjamanId;
        this.judulfilm = judulfilm;
        this.durasi = durasi;
    }

    //Getter dan Setter
    public int getPeminjamanId(){
        return peminjamanId;
    }

    public void setPeminjamanId(int peminjamanId){
        this.peminjamanId = peminjamanId;
    }

    public String getJudulfilm(){
        return judulfilm;
    }

    public void setJudulfilm(String judulfilm){
        this.judulfilm = judulfilm;
    }
    public int getDurasi(){
        return durasi;
    }

    public void setDurasi(int durasi){
        this.durasi = durasi;
    }
}
    
