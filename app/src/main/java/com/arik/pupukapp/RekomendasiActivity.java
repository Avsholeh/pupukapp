package com.arik.pupukapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.arik.pupukapp.database.DataAcuan;
import com.arik.pupukapp.database.DatabaseHelper;

import java.util.List;


public class RekomendasiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi);

        DatabaseHelper db = new DatabaseHelper(this);
        TableLayout tableLayout = (TableLayout) findViewById(R.id.acuantable);
        List<DataAcuan> fertilizers = db.getAllDataAcuan();

        for (DataAcuan cn : fertilizers) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView tvId = new TextView(this);
            TextView tvKabupaten = new TextView(this);
            TextView tvKecamatan = new TextView(this);
            TextView tvNitrogen = new TextView(this);
            TextView tvPhosphorus = new TextView(this);
            TextView tvPotassium = new TextView(this);

            tvId.setText(String.valueOf(cn.getId()));
            tvKabupaten.setText(cn.getKabupaten());
            tvKecamatan.setText(cn.getKecamatan());
            tvNitrogen.setText(String.valueOf(cn.getNitrogen()));
            tvPhosphorus.setText(String.valueOf(cn.getPhosphorus()));
            tvPotassium.setText(String.valueOf(cn.getPotassium()));

            tvId.setPadding(4,4,4,4);
            tvKabupaten.setPadding(4,4,4,4);
            tvKecamatan.setPadding(4,4,4,4);
            tvNitrogen.setPadding(4,4,4,4);
            tvPhosphorus.setPadding(4,4,4,4);
            tvPotassium.setPadding(4,4,4,4);

            row.addView(tvId);
            row.addView(tvKabupaten);
            row.addView(tvKecamatan);
            row.addView(tvNitrogen);
            row.addView(tvPhosphorus);
            row.addView(tvPotassium);

            tableLayout.addView(row);

        }
    }
}
