package com.dev.kedaiit.sibooks.model;

public class DataPenerbit {
    public DataPenerbit(){
        this.id_penerbit = id_penerbit;
        this.penerbit = penerbit;
    }

    public String getId_penerbit() {
        return id_penerbit;
    }

    public void setId_penerbit(String id_penerbit) {
        this.id_penerbit = id_penerbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    String id_penerbit, penerbit;
}
