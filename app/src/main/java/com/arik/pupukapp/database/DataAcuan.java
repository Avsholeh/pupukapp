package com.arik.pupukapp.database;

public class DataAcuan {

    private int id;
    private String kabupaten;
    private String kecamatan;
    private int nitrogen;
    private int phosphorus;
    private int potassium;

    public DataAcuan() {
    }

    public DataAcuan(int id, String kecamatan, int nitrogen, int phosphorus, int potassium) {
        this.id = id;
        this.kecamatan = kecamatan;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    public DataAcuan(int id, String kabupaten, String kecamatan, int nitrogen, int phosphorus, int potassium) {
        this.id = id;
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    public DataAcuan(String kecamatan, int nitrogen, int phosphorus, int potassium) {
        this.kecamatan = kecamatan;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    public DataAcuan(String kabupaten, String kecamatan, int nitrogen, int phosphorus, int potassium) {
        this.kabupaten = kabupaten;
        this.kecamatan = kecamatan;
        this.nitrogen = nitrogen;
        this.phosphorus = phosphorus;
        this.potassium = potassium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public int getNitrogen() {
        return nitrogen;
    }

    public void setNitrogen(int nitrogen) {
        this.nitrogen = nitrogen;
    }

    public int getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(int phosphorus) {
        this.phosphorus = phosphorus;
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }
}
