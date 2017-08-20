package com.arik.pupukapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.arik.pupukapp.database.DataPupuk;
import com.arik.pupukapp.database.DatabaseHelper;

import java.util.List;

public class PupukActivity extends AppCompatActivity {

    Intent intent;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pupuk);

        tableLayout = (TableLayout) findViewById(R.id.pupuktable);
        Button btnTambah = (Button) findViewById(R.id.btn_tambah);
        Button btnEdit = (Button) findViewById(R.id.btn_edit);
        Button btnHapus = (Button) findViewById(R.id.btn_hapus);


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), TambahPupukActivity.class);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), EditPupukActivity.class);
                startActivity(intent);
            }
        });


        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), HapusPupukActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        showDataPupuk();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tableLayout.removeAllViews();
    }

    private void showDataPupuk() {

        DatabaseHelper db = new DatabaseHelper(this);
        List<DataPupuk> dataPupukList = db.getAllDataPupuk();

        TableRow.LayoutParams lp = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);

        addTitleColumn(lp);

        for (DataPupuk dataPupuk : dataPupukList) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(lp);
            row.setGravity(Gravity.CENTER_HORIZONTAL);

            PupukTextView tvNama = new PupukTextView(this, false);
            PupukTextView tvN = new PupukTextView(this, false);
            PupukTextView tvP = new PupukTextView(this, false);
            PupukTextView tvK = new PupukTextView(this, false);
            PupukTextView tvHarga = new PupukTextView(this, false);

            tvNama.setText(String.valueOf(dataPupuk.getNama()));
            tvN.setText(String.valueOf(dataPupuk.getKadarN()));
            tvP.setText(String.valueOf(dataPupuk.getKadarP()));
            tvK.setText(String.valueOf(dataPupuk.getKadarK()));
            tvHarga.setText(String.valueOf("Rp. " + dataPupuk.getHarga()));

            row.addView(tvNama);
            row.addView(tvN);
            row.addView(tvP);
            row.addView(tvK);
            row.addView(tvHarga);

            tableLayout.addView(row);
        }

    }

    private void addTitleColumn(TableRow.LayoutParams lp) {
        TableRow row = new TableRow(this);
        row.setLayoutParams(lp);
        row.setGravity(Gravity.CENTER_HORIZONTAL);

        PupukTextView tvNama = new PupukTextView(this, true);
        PupukTextView tvN = new PupukTextView(this, true);
        PupukTextView tvP = new PupukTextView(this, true);
        PupukTextView tvK = new PupukTextView(this, true);
        PupukTextView tvHarga = new PupukTextView(this, true);

        tvNama.setText(String.valueOf("Nama"));
        tvN.setText(String.valueOf("N"));
        tvP.setText(String.valueOf("P"));
        tvK.setText(String.valueOf("K"));
        tvHarga.setText(String.valueOf("Harga"));

        row.addView(tvNama);
        row.addView(tvN);
        row.addView(tvP);
        row.addView(tvK);
        row.addView(tvHarga);

        tableLayout.addView(row);
    }

}



//        Object[][] rawFertilizer = new Object[][]{
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