package com.dev.kedaiit.sibooks.model;

public class DataKategori {
    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    String id_kategori, kategori;

    public DataKategori(){
        this.id_kategori = id_kategori;
        this.kategori = kategori;
    }
}
