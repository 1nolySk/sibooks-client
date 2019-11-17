package com.dev.kedaiit.sibooks.ModelData;

public class ModelDataKategori {
    public String getId_kategori() {
        return id_kategori;
    }

    public ModelDataKategori(String id_kategori, String kategori){
        this.id_kategori = id_kategori;
        this.kategori = kategori;
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

    public ModelDataKategori(){}
}
