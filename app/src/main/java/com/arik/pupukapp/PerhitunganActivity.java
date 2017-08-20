package com.arik.pupukapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class PerhitunganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan_2);

        TextView tvPemupukan = (TextView) findViewById(R.id.pemupukan);
        TextView tvKandungan = (TextView) findViewById(R.id.kandungan);
        TextView tvKromosom = (TextView) findViewById(R.id.kromosom);
        TextView tvIndividu = (TextView) findViewById(R.id.individu);
        TextView tvPenalty = (TextView) findViewById(R.id.penalty);
        TextView tvFitness = (TextView) findViewById(R.id.fitness);

        DataHasil dataHasil = MainActivity.dataHasil;

        if (dataHasil.isCalculated()) {
            StringBuilder sb = new StringBuilder();
//            sb.append("- Rekomendasi Pemupukan N, P, K: \n");
            sb.append("N = ").append(dataHasil.getN()).append("\n");
            sb.append("P = ").append(dataHasil.getP()).append("\n");
            sb.append("K = ").append(dataHasil.getK());
//
//            String pemupukan = "- Rekomendasi Pemupukan N, P, K: \n" +
//                    "N = " + dataHasil.getN() + "\n" +
//                    "P = " + dataHasil.getP() + "\n" +
//                    "K = " + dataHasil.getK() + "\n";
            tvPemupukan.setText(sb.toString());
            sb.delete(0, sb.capacity());
//
//            sb.append("- Perhitungan Kandungan: \n")
//                    .append("Rumus: Nutrisi = Kandungan (%) x Jumlah Pupuk yg dibutuhkan\n");

            sb.append("N = ").append(dataHasil.getN()).append(" x ")
                    .append(ProsesActivity.NUTRISI_NITROGEN).append(" = ")
                    .append(dataHasil.getN() * ProsesActivity.NUTRISI_NITROGEN).append("\n");

            sb.append("P = ").append(dataHasil.getP()).append(" x ")
                    .append(ProsesActivity.NUTRISI_PHOSPHORUS).append(" = ")
                    .append(dataHasil.getP() * ProsesActivity.NUTRISI_PHOSPHORUS).append("\n");

            sb.append("K = ").append(dataHasil.getK()).append(" x ")
                    .append(ProsesActivity.NUTRISI_POTASSIUM).append(" = ")
                    .append(dataHasil.getK() * ProsesActivity.NUTRISI_POTASSIUM);
//            String kandungan = "- Perhitungan Kandungan: \n" +
//                    "Rumus: Nutrisi = Kandungan (%) x Jumlah Pupuk yg dibutuhkan\n" +
//                    "N = " + dataHasil.getN() + " * 0.46 = " + (dataHasil.getN() * 0.46) + "\n" +
//                    "P = " + dataHasil.getP() + " * 0.36 = " + (dataHasil.getP() * 0.36) + "\n" +
//                    "P = " + dataHasil.getK() + " * 0.60 = " + (dataHasil.getK() * 0.60) + "\n";
            tvKandungan.setText(sb.toString());
//
//            String kromosom = "- Kromosom Terpilih: \n" +
//                    dataHasil.getIndividuTerpilih() + "\n";
            tvKromosom.setText(dataHasil.getIndividuTerpilih());
//
//            String indiv = "- Mencari kandungan 5 individu pertama: \n" +
//                    dataHasil.getIndividu() + "\n";
            tvIndividu.setText(dataHasil.getIndividu());

//            String penalty = "- Perhitungan Penalty: \n" +
//                    "Kebutuhan N + Kebutuhan P + Kebutuhan K\n" +
//                    dataHasil.getPenalty() + "\n";
            tvPenalty.setText(String.valueOf(dataHasil.getPenalty()));

//            String fitness = "- Perhitungan Fitness: \n" +
//                    "1000 / (Total Harga / 1000) + (1000 * penalty)\n" +
//                    dataHasil.getFitness() + "\n";
            tvFitness.setText(dataHasil.getFitness());


        }


    }
}
