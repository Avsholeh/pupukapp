package com.arik.pupukapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.arik.pupukapp.database.DataAcuan;
import com.arik.pupukapp.database.DatabaseHelper;
import com.arik.pupukapp.database.DataPupuk;

public class MainActivity extends AppCompatActivity {

    private Button pupukBtn;
    private Button acuanBtn;
    private Button inputBtn;
    private Intent layout;
    public static DataHasil dataHasil = new DataHasil();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_main);
        mainLayout.setBackgroundResource(R.drawable.background_main);


        pupukBtn = (Button) findViewById(R.id.btn_pupuk);
        acuanBtn = (Button) findViewById(R.id.btn_acuan);
        inputBtn = (Button) findViewById(R.id.btn_input);

        DatabaseHelper db = new DatabaseHelper(this);

        if (!DatabaseHelper.doesDatabaseExist(this)) {
            Log.d("LOG", "Creating Database.");
            Log.d("LOG", "Creating Data Acuan.");
            createDataAcuan(db);
            Log.d("LOG", "Creating Data Pupuk.");
            createDataPupuk(db);
            Log.d("LOG", "Process complete.");

        } else {
            Log.d("LOG", "Database is available.");
        }

        pupukBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = new Intent(getApplicationContext(), PupukActivity.class);
                startActivity(layout);
            }
        });

        acuanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = new Intent(getApplicationContext(), RekomendasiActivity.class);
                startActivity(layout);
            }
        });

        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout = new Intent(getApplicationContext(), ProsesActivity.class);
                startActivity(layout);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void createDataAcuan(DatabaseHelper db) {
        Log.d("Insert: ", "Inserting data Blitar");
        db.addDataAcuan(new DataAcuan("Blitar", "Sanan wetan", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Blitar", "Sanan kulon", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Blitar", "Kepanjen kidul", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Blitar", "Sukorejo", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Blitar", "Garum", 250, 50, 75));
        db.addDataAcuan(new DataAcuan("Blitar", "Kanigoro", 250, 50, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Selopuro", 225, 50, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Bakung", 250, 150, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Sutojayan", 250, 50, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Panggungrejo", 300, 50, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Binangun", 225, 100, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Wates", 225, 150, 100));
        db.addDataAcuan(new DataAcuan("Blitar", "Kesamben", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Doko", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Wlingi", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Talun", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Gandusari", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Nglegok", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Ponggok", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Srengat", 250, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Udanawu", 250, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Kademangan", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Selorejo", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Wonodadi", 225, 100, 50));
        db.addDataAcuan(new DataAcuan("Blitar", "Wonotirto", 225, 100, 50));

        Log.d("Insert: ", "Inserting data Pasuruan");
        db.addDataAcuan(new DataAcuan("Pasuruan", "Lekok", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Nguling", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Lumbang", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Rejoso", 225, 100, 75));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Gondangwetan", 250, 50, 75));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Kejayan", 250, 50, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Winongan", 225, 50, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Grati", 250, 150, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Pasrepan", 250, 50, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Tosari", 300, 50, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Puspo", 225, 100, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Tutur", 225, 150, 100));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Purwodadi", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Purwosari", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Wonorejo", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Sukorejo", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Prigen", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Pandaan", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Gempol", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Beji", 250, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Bangil", 250, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Rembang", 225, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Kraton", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Pohjentrek", 225, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Purworejo", 225, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Gadingrejo", 225, 100, 50));
        db.addDataAcuan(new DataAcuan("Pasuruan", "Bugulkidul", 225, 100, 50));

        Log.d("Insert: ", "Inserting data Probolinggo");
        db.addDataAcuan(new DataAcuan("Probolinggo", "Kademangan",  300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Mayangan",  300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Wonoasih",  300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Dringu",  250, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Gending",  250, 50, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Pejarakan",  300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Kraksaan",  225, 150, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Krejengan",  300, 150, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Paiton",  300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Kotaanyar",  300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Pakuniran",  325, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Gading",  325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Krucil",  325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Tiris",  300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Maron",  300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Banyuanyar", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Leces", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Bantaran", 325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Tongas", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Lumbang", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Sukapura", 325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Kuripan", 325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Sumber", 325, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Tegal Siwalan", 300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Besuk", 300, 100, 100));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Sumberasih", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Probolinggo", "Wonomerto", 325, 100, 50));

        Log.d("Insert: ", "Inserting data Kediri");
        db.addDataAcuan(new DataAcuan("Kediri", "Kediri",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Pesantren",250,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Mojoroto",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Ringinrejo",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Semen",300,100,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Grogol",300,75,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Banyakan",300,100,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Kandat",250,100,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Kras",250,100,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Wates",300,100,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Plosoklaten",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Puncu",225,150,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Kepung",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Kandangan",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Ngancar",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Gurah",225,150,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Pagu",225,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Pare",250,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Papar",300,75,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Purwosari",225,75,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Plemahan",225,75,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Kunjang",300,75,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Ngadiluwih",300,100,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Tarakan",300,75,100));
        db.addDataAcuan(new DataAcuan("Kediri", "Gampingrejo",250,75,50));
        db.addDataAcuan(new DataAcuan("Kediri", "Wojo",250,100,50));

        Log.d("Insert: ", "Inserting data Malang");
        db.addDataAcuan(new DataAcuan("Malang", "Klojen", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Blimbing", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Kedungkandang", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Sukun", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Lowokwaru", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Pakis", 300, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Tumpang", 250, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Poncokusumo", 250, 75, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Wajak", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Tajinan", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Pakisaji", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Bululawang", 250, 100, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Gondanglegi", 250, 100, 100));
        db.addDataAcuan(new DataAcuan("Malang", "Pagelaran",250,100,100));
        db.addDataAcuan(new DataAcuan("Malang", "Ampelgading", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Tirtoyudo", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Dampit", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Sumbermanjing", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Gedangan", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Bantur", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Donomulyo", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Kalipare", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Pagak", 300, 150, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Kepanjen", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Kromengan", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Sumberpucung", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Ngajum", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Wonosari", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Wagir", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Dau", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Pujon",300,75,50));
        db.addDataAcuan(new DataAcuan("Malang", "Ngantang",300,75,50));
        db.addDataAcuan(new DataAcuan("Malang", "Kasembon", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Karangploso", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Singosari", 300, 100, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Jabung", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Lawang", 300, 75, 50));
        db.addDataAcuan(new DataAcuan("Malang", "Turen", 300, 75, 50));

    }

    public void createDataPupuk(DatabaseHelper db) {
        db.addDataPupuk(new DataPupuk("ZA", 21, 0, 0, 1400));
        db.addDataPupuk(new DataPupuk("SP-36", 0, 36, 0, 2000));
        db.addDataPupuk(new DataPupuk("ZK", 0, 0, 50, 5600));
        db.addDataPupuk(new DataPupuk("KCL-80", 0, 0, 52, 3500));
        db.addDataPupuk(new DataPupuk("KCL canada", 0, 0, 60, 8000));
        db.addDataPupuk(new DataPupuk("Urea", 46, 0, 0, 1800));
        db.addDataPupuk(new DataPupuk("Phonska", 15, 15, 15, 2300));
        db.addDataPupuk(new DataPupuk("KCL rusia", 0, 0, 60, 5000));
        db.addDataPupuk(new DataPupuk("NPK Mutiara", 16, 16, 16, 9000));
    }
}
