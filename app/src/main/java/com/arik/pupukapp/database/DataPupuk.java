package com.arik.pupukapp.database;

public class DataPupuk {
    public int id;
    public String nama;
    public double kadarN;
    public double kadarP;
    public double kadarK;
    public double harga;

    public DataPupuk() {}

    public DataPupuk(String nama, double kadarN, double kadarP, double kadarK, double harga) {
        this.nama = nama;
        this.kadarN = kadarN;
        this.kadarP = kadarP;
        this.kadarK = kadarK;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getKadarN() {
        return kadarN;
    }

    public double getKadarP() {
        return kadarP;
    }

    public double getKadarK() {
        return kadarK;
    }

    public double getHarga() {
        return harga;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKadarN(double kadarN) {
        this.kadarN = kadarN;
    }

    public void setKadarP(double kadarP) {
        this.kadarP = kadarP;
    }

    public void setKadarK(double kadarK) {
        this.kadarK = kadarK;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
