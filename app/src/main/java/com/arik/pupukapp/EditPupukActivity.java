package com.arik.pupukapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.arik.pupukapp.database.DataPupuk;
import com.arik.pupukapp.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class EditPupukActivity extends AppCompatActivity {

    DatabaseHelper database;
    List<DataPupuk> dataPupuk;
    Spinner namaPupuk;
    EditText kadarN;
    EditText kadarP;
    EditText kadarK;
    EditText harga;
    Button btnSimpan;
    String selectedPupuk;
    int idPupuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pupuk_edit);

        namaPupuk = (Spinner) findViewById(R.id.nama_pupuk);
        kadarN = (EditText) findViewById(R.id.kadar_n);
        kadarP = (EditText) findViewById(R.id.kadar_p);
        kadarK = (EditText) findViewById(R.id.kadar_k);
        harga = (EditText) findViewById(R.id.harga);
        btnSimpan = (Button) findViewById(R.id.btn_simpan);

        database = new DatabaseHelper(this);
        dataPupuk = database.getAllDataPupuk();
        idPupuk = dataPupuk.get(0).getId();

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
                selectedPupuk = (String) parent.getSelectedItem();
                for (DataPupuk dp : dataPupuk) {
                    if (dp.getNama().equalsIgnoreCase(selectedPupuk)) {
                        setPupukData(dp);
                        idPupuk = dp.getId();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // just empty method, gaes!
            }
        });

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpanData();
//                startActivity(new Intent(getApplicationContext(), PupukActivity.class));
                Toast.makeText(getApplicationContext(), "Perubahan telah berhasil disimpan", Toast.LENGTH_SHORT).show();
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

    private void setPupukData(DataPupuk dataPupuk) {
        kadarN.setText(String.valueOf(dataPupuk.getKadarN()));
        kadarP.setText(String.valueOf(dataPupuk.getKadarP()));
        kadarK.setText(String.valueOf(dataPupuk.getKadarK()));
        harga.setText(String.valueOf(dataPupuk.getHarga()));
    }

    private void simpanData() {
        DataPupuk dp = new DataPupuk();
        dp.setId(idPupuk);
        dp.setNama(selectedPupuk);
        dp.setKadarN(Double.parseDouble(kadarN.getText().toString()));
        dp.setKadarP(Double.parseDouble(kadarP.getText().toString()));
        dp.setKadarK(Double.parseDouble(kadarK.getText().toString()));
        dp.setHarga(Double.parseDouble(harga.getText().toString()));
        System.out.println(database.updateDataPupuk(dp));
    }

}
