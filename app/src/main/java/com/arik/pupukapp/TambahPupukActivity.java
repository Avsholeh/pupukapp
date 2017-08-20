package com.arik.pupukapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arik.pupukapp.database.DataPupuk;
import com.arik.pupukapp.database.DatabaseHelper;

public class TambahPupukActivity extends AppCompatActivity {

    EditText nama;
    EditText kadarN;
    EditText kadarP;
    EditText kadarK;
    EditText harga;
    Button btnSimpan;

    DatabaseHelper database;

    private String valueNama;
    private double valueKadarN;
    private double valueKadarP;
    private double valueKadarK;
    private double valueHarga;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pupuk_tambah);

        // widget instance
        nama = (EditText) findViewById(R.id.nama_pupuk);
        kadarN = (EditText) findViewById(R.id.kadar_n);
        kadarP = (EditText) findViewById(R.id.kadar_p);
        kadarK = (EditText) findViewById(R.id.kadar_k);
        harga = (EditText) findViewById(R.id.harga);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);

        Button btnKembali = (Button) findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // variable database
        database = new DatabaseHelper(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check value sebelum nge-set value ke variable
                if (checkValue()) {
                    setValue();
                    saveToDatabase();
                    Toast.makeText(getApplicationContext(), "Data Pupuk " + valueNama + " telah berhasil disimpan", Toast.LENGTH_SHORT).show();
                    onBackPressed();

                } else {
                    Toast.makeText(getApplicationContext(), "Maaf! tidak boleh ada form yang kosong", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    // Menentukan value terhadap variable yang mana data akan disimpan ke database
    private void setValue() {
        valueNama = nama.getText().toString();
        valueKadarN = Double.parseDouble(kadarN.getText().toString());
        valueKadarP = Double.parseDouble(kadarP.getText().toString());
        valueKadarK = Double.parseDouble(kadarK.getText().toString());
        valueHarga = Double.parseDouble(harga.getText().toString());
    }

    // Menambahkan data yang ada pada form ke dalam database
    private void saveToDatabase() {
        DataPupuk dataPupuk = new DataPupuk();
        dataPupuk.setNama(valueNama);
        dataPupuk.setKadarN(valueKadarN);
        dataPupuk.setKadarP(valueKadarP);
        dataPupuk.setKadarK(valueKadarK);
        dataPupuk.setHarga(valueHarga);

        // insert into database begin, gaes!
        database.addDataPupuk(dataPupuk);
    }

    // Validasi setiap form
    private boolean checkValue() {

        if (nama.getText().toString().equals("")) {
            return false;

        } else if (kadarN.getText().toString().equals("")) {
            return false;

        } else if (kadarP.getText().toString().equals("")) {
            return false;

        } else if (kadarK.getText().toString().equals("")) {
            return false;

        } else if (harga.getText().toString().equals("")) {
            return false;
        }
        return true;

    }


}
