//package com.arik.pupukapp;
//
//
//import com.arik.pupukapp.method.IndividualImpl;
//
//public class DataPerhitungan {
//    public boolean status;
//    public double n;
//    public double p;
//    public double k;
//    public double penalty;
//    public double fitness;
//    public IndividualImpl ga;
//
//    public String kabupaten;
//    public String kecamatan;
//    public int target;
//    public int luasTanah;
//
//
//    public Integer[] nilaiKromosom;
//    public String[] namaKromosom;
//    public Integer[] individu;
//    public Object[][] rawFertilizer;
//
//    public double getPenalty() {
//        return penalty;
//    }
//
//    public void setPenalty(double penalty) {
//        this.penalty = penalty;
//    }
//
//    public double getFitness() {
//        return fitness;
//    }
//
//    public void setFitness(double fitness) {
//        this.fitness = fitness;
//    }
//
//    public DataPerhitungan() {
//        namaKromosom = new String[9];
//        namaKromosom[0] = "Za";
//        namaKromosom[1] = "SP-36";
//        namaKromosom[2] = "ZK";
//        namaKromosom[3] = "KCL-80";
//        namaKromosom[4] = "KCL canada";
//        namaKromosom[5] = "Urea";
//        namaKromosom[6] = "Phoska";
//        namaKromosom[7] = "KCL rusia";
//        namaKromosom[8] = "NPK Mutiara";
//
//        nilaiKromosom = new Integer[9];
//
//        rawFertilizer = new Object[][]{
//                new Object[]{"Za", 21, 0, 0, 1400},
//                new Object[]{"SP-36", 0, 36, 0, 2000},
//                new Object[]{"ZK", 0, 0, 50, 5600},
//                new Object[]{"KCL-80", 0, 0, 52, 3500},
//                new Object[]{"KCL canada", 0, 0, 60, 8000},
//                new Object[]{"Urea", 46, 0, 0, 1800},
//                new Object[]{"Phonska", 15, 15, 15, 2300},
//                new Object[]{"KCL rusia", 0, 0, 60, 5000},
//                new Object[]{"NPK Mutiara", 16, 16, 16, 9000},
//        };
//    }
//
//    public double getN() {
//        return n;
//    }
//
//    public void setN(double n) {
//        this.n = n;
//    }
//
//    public double getP() {
//        return p;
//    }
//
//    public void setP(double p) {
//        this.p = p;
//    }
//
//    public double getK() {
//        return k;
//    }
//
//    public void setK(double k) {
//        this.k = k;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
//
//    public void setStatus(boolean status) {
//        this.status = status;
//    }
//
//    public String getKabupaten() {
//        return kabupaten;
//    }
//
//    public void setKabupaten(String kabupaten) {
//        this.kabupaten = kabupaten;
//    }
//
//    public String getKecamatan() {
//        return kecamatan;
//    }
//
//    public void setKecamatan(String kecamatan) {
//        this.kecamatan = kecamatan;
//    }
//
//    public int getTarget() {
//        return target;
//    }
//
//    public void setTarget(int target) {
//        this.target = target;
//    }
//
//    public int getLuasTanah() {
//        return luasTanah;
//    }
//
//    public void setLuasTanah(int luasTanah) {
//        this.luasTanah = luasTanah;
//    }
//
//    public String getNilaiKromosom() {
//        String k = "";
//        for (Integer n : nilaiKromosom) {
//            k += n + " ";
//        }
//        return k;
//    }
//
//    public void setNilaiKromosom(Integer[] nilaiKromosom) {
//        this.nilaiKromosom = nilaiKromosom;
//    }
//
//    public void setIndividu(Integer[] ind) {
//        this.individu = ind;
//    }
//
//    public String getIndividu() {
//        String ind = "";
//        for (int i = 0; i < individu.length; i++) {
//            ind += individu[i] + ": N = " + rawFertilizer[individu[i]][1] + ", P = " + rawFertilizer[individu[i]][2] + ", K = " + rawFertilizer[individu[i]][3] + "\n";
//        }
//        return ind;
//    }
//
//    public String getKromosom() {
//        String k = "";
//        for (int i = 0; i < nilaiKromosom.length; i++) {
//            k += nilaiKromosom[i] + " " + namaKromosom[nilaiKromosom[i]] + "\n";
//        }
//        return k;
//    }
//
//}
