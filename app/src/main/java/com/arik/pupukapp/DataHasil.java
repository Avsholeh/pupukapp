package com.arik.pupukapp;

import com.arik.pupukapp.dao.Fertilizer;
import com.arik.pupukapp.method.GeneticsAlgorithmImpl;
import com.arik.pupukapp.method.utils.Int2DoubleMap;

import java.text.DecimalFormat;
import java.util.List;

public class DataHasil {

    private GeneticsAlgorithmImpl geneticsAlgorithm;
    private List<Fertilizer> dataPupukList;

    public String kabupaten;
    public String kecamatan;
    public String unitTarget;
    public String unitLuasTanah;
    private String individuTerpilih;
    public double target;
    public double luasTanah;
    public double harga;
    public double n;
    public double p;
    public double k;

    public String nilaiKromosom;

    private DecimalFormat df;

    public DataHasil() {
        df = new DecimalFormat("0");
        df.setMaximumFractionDigits(340);
    }

    public void setGeneticsAlgorithm(GeneticsAlgorithmImpl ga) {
        this.geneticsAlgorithm = ga;
    }

    public GeneticsAlgorithmImpl getGeneticsAlgorithm() {
        return geneticsAlgorithm;
    }

    public void setDataPupuk(List<Fertilizer> dataPupuk) {
        dataPupukList = dataPupuk;
    }

    public List<Fertilizer> getDataPupukList() {
        return dataPupukList;
    }

    public boolean isCalculated() {
        if (geneticsAlgorithm != null && dataPupukList != null) return true;
        else return false;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getLuasTanah() {
        return luasTanah;
    }

    public void setLuasTanah(double luasTanah) {
        this.luasTanah = luasTanah;
    }

    public double getPenalty() {
        return geneticsAlgorithm.getBest().getPenalty();
    }

    public String getFitness() {
        double fitness = geneticsAlgorithm.getBest().getFitness();
        return df.format(fitness);
    }

    public String getIndividu() {
        Integer[] individu = geneticsAlgorithm.getBest().getProcessedFertilizer();
        Fertilizer fertilizer;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < individu.length; i++) {
            int temp = individu[i];
            fertilizer = getDataPupukList().get(temp);
            sb.append(temp).append(" = ")//.append(fertilizer.getName()).append(", ");
                    .append("N = ").append(getDataPupukList().get(temp).getElements().get("nitrogen")).append(", ")
                    .append("P = ").append(getDataPupukList().get(temp).getElements().get("phosphorus")).append(", ")
                    .append("K = ").append(getDataPupukList().get(temp).getElements().get("potassium")).append(", ");
            if (i != individu.length - 1) sb.append("\n");

//            textIndividu += individu[i] + ": " +
//
//                    "N = " + dataPupukList.get(individu[i]).getElements().get("nitrogen") + ", " +
//                    "P = " + dataPupukList.get(individu[i]).getElements().get("phosphorus") + ", " +
//                    "K = " + dataPupukList.get(individu[i]).getElements().get("potassium") + "\n";
        }

        return sb.toString();
    }

    private void setNilaiKromosom() {
        Int2DoubleMap supply = geneticsAlgorithm.getBest().getSupply();
        Object supplyKey[] = geneticsAlgorithm.getBest().getSupply().keySet().toArray();
        StringBuilder sb = new StringBuilder();
        Fertilizer fert;
        for (int i = 0; i < supplyKey.length; i++) {
            fert = getDataPupukList().get((int) supplyKey[i]);
            sb.append(fert.getName()).append(" = ").append(supply.get(supplyKey[i])).append(" Kg");
            if (i != supplyKey.length - 1) sb.append("\n");
        }
        nilaiKromosom = sb.toString();

    }

    public String getNilaiKromosom() {
        setNilaiKromosom();
        return nilaiKromosom;
    }

    public void setIndividuTerpilih() {
        Integer[] kromosom = geneticsAlgorithm.getBest().getFertilizers();
        StringBuilder sb = new StringBuilder();
        Fertilizer fert;
        for (int i = 0; i < kromosom.length; i++) {
            fert = getDataPupukList().get(kromosom[i]);
            sb.append(kromosom[i]).append(" = ").append(fert.getName());
            if (i != kromosom.length - 1) sb.append("\n");
        }
        individuTerpilih = sb.toString();
    }

    public String getIndividuTerpilih() {
        setIndividuTerpilih();
        return individuTerpilih;
    }

    public String getHarga() {
        double harga = geneticsAlgorithm.getBest().getCost();
        return df.format(harga);
    }
//
//    public double getHarga() {
//        return geneticsAlgorithm.getBest().getCost();
//    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public String getUnitTarget() {
        return unitTarget;
    }

    public void setUnitTarget(String unitTarget) {
        this.unitTarget = unitTarget;
    }

    public String getUnitLuasTanah() {
        return unitLuasTanah;
    }

    public void setUnitLuasTanah(String unitLuasTanah) {
        this.unitLuasTanah = unitLuasTanah;
    }
}
