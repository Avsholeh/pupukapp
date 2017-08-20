package com.arik.pupukapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HasilProsesActivity extends AppCompatActivity {

    TextView tvKeterangan;
    TextView tvKromosom;
    TextView tvPenalty;
    TextView tvFitness;
    TextView tvHarga;

    Button btnProsesLagi;
    Button btnPerhitungan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_proses_2);

        tvKeterangan = (TextView) findViewById(R.id.keterangan);
        tvKromosom = (TextView) findViewById(R.id.kromosom);
        tvPenalty = (TextView) findViewById(R.id.penalty);
        tvFitness = (TextView) findViewById(R.id.fitness);
        tvHarga = (TextView) findViewById(R.id.harga);

        //button
        btnProsesLagi = (Button) findViewById(R.id.btn_proses_lagi);
        btnPerhitungan = (Button) findViewById(R.id.btn_perhitungan);


        DataHasil dataHasil = MainActivity.dataHasil;

        if (dataHasil.isCalculated()) {

            tvKeterangan.setText("Solusi terbaik yang dibutuhkan kecamatan " + dataHasil.getKecamatan() +
                    " untuk target sebesar " + dataHasil.getTarget() + " " +
                    dataHasil.getUnitTarget() + " dan luas tanah " +
                    dataHasil.getLuasTanah() + " " +
                    dataHasil.getUnitLuasTanah() + " adalah: ");

            tvKromosom.setText(dataHasil.getNilaiKromosom());

            // penalty
            tvPenalty.setText(String.valueOf(dataHasil.getPenalty()));

            // fitness
            tvFitness.setText(dataHasil.getFitness());

            // harga
            String tvHargaText = "Rp. " + dataHasil.getHarga();
            tvHarga.setText(tvHargaText);

        } else {

            Toast.makeText(this, "Maaf, terdapat kesalahan pada aplikasi kami.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnProsesLagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnPerhitungan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerhitunganActivity.class));
            }
        });
    }
}
