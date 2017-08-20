package com.arik.pupukapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.arik.pupukapp.database.DataPupuk;
import com.arik.pupukapp.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class HapusPupukActivity extends AppCompatActivity {

    DatabaseHelper database;
    Spinner namaPupuk;
    Button btnHapus;
    List<DataPupuk> dataPupuk;
    String selectedPupuk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pupuk_hapus);

        namaPupuk = (Spinner) findViewById(R.id.nama_pupuk);
        btnHapus = (Button) findViewById(R.id.btn_hapus);

        database = new DatabaseHelper(this);
        dataPupuk = database.getAllDataPupuk();

        Button btnKembali = (Button) findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        addOnSpinnerNamaPupuk();

        namaPupuk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPupuk = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusDataPupuk(selectedPupuk);
                onBackPressed();
            }
        });

    }

    private void addOnSpinnerNamaPupuk() {
        List<String> namaPupuks = new ArrayList<String>();
        for (DataPupuk dp : dataPupuk) {
            namaPupuks.add(dp.getNama());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, namaPupuks);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        namaPupuk.setAdapter(dataAdapter);
    }

    private void hapusDataPupuk(String text) {
        for (DataPupuk dp : dataPupuk) {
            if (dp.getNama().equals(text)) {
                if (database.deleteDataPupuk(dp) == 1) {
                    String toastText = "Data Pupuk " + selectedPupuk + " telah berhasil dihapus";
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}
