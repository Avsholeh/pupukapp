package com.arik.pupukapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.CornPlantation;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.Fertilizer;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.dao.PlantationScale;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.GeneticsAlgorithmImpl;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.IndividualImpl;
import app.freelancer.syafiqq.evolutionary.discrete.genetics.algorithm.cases.a.model.method.SettingImpl;
import com.arik.pupukapp.database.DataAcuan;
import com.arik.pupukapp.database.DataPupuk;
import com.arik.pupukapp.database.DatabaseHelper;

import com.github.syafiqq.unit.conversion.core.unit.compound.AreaDensityUnit;
import java.util.ArrayList;
import java.util.List;


public class ProsesActivity extends AppCompatActivity {

    private static final String UNIT_TARGET_KG = "Kg";
    private static final String UNIT_TARGET_TON = "Ton";
    private static final String UNIT_LUAS_TANAH_HA = "Ha";
    private static final String UNIT_LUAS_TANAH_METER = "M2";

    public static final double NUTRISI_NITROGEN = 0.46;
    public static final double NUTRISI_PHOSPHORUS = 0.36;
    public static final double NUTRISI_POTASSIUM = 0.60;

    private DatabaseHelper database;
    private Spinner kabupaten;
    private Spinner kecamatan;
    private Spinner unitTarget;
    private Spinner unitLuasTanah;

    private EditText target;
    private EditText luasTanah;
    private EditText popSize;
    private EditText generasi;
    private EditText crossoverRate;
    private EditText mutationRate;

    private Button proses;
    private String selectedKecamatan = "";
    private String selectedUnitTarget = UNIT_TARGET_TON;
    private String selectedUnitLuasTanah = UNIT_LUAS_TANAH_HA;

    public GeneticsAlgorithmImpl ga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proses);

        target = (EditText) findViewById(R.id.target);
        luasTanah = (EditText) findViewById(R.id.luastanah);
        popSize = (EditText) findViewById(R.id.popsize);
        generasi = (EditText) findViewById(R.id.generasi);
        crossoverRate = (EditText) findViewById(R.id.cr);
        mutationRate = (EditText) findViewById(R.id.mr);

        kabupaten = (Spinner) findViewById(R.id.kabupaten);
        kecamatan = (Spinner) findViewById(R.id.kecamatan);
        proses = (Button) findViewById(R.id.btn_proses);

        unitTarget = (Spinner) findViewById(R.id.spin_unit_target);
        unitLuasTanah = (Spinner) findViewById(R.id.spin_unit_luas_tanah);

        database = new DatabaseHelper(this);

        addOnSpinnerUnit(unitTarget, new String[] {UNIT_TARGET_TON, UNIT_TARGET_KG});
        addOnSpinnerUnit(unitLuasTanah, new String[] {UNIT_LUAS_TANAH_HA, UNIT_LUAS_TANAH_METER});

        addOnSpinnerKabupaten();
        addOnSpinnerKecamatan("Blitar");

        kabupaten.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Menambahkan daftar kecamatan berdasarkan kabupaten yang dipilih
                // sehingga menu dropdown menjadi dinamis
                addOnSpinnerKecamatan((String) parent.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        kecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedKecamatan = (String) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            proses();
            Intent intent = new Intent(getApplicationContext(), HasilProsesActivity.class);
            startActivity(intent);
            }
        });

        unitTarget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUnitTarget = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unitLuasTanah.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedUnitLuasTanah = parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    // Menambahkan daftar kabupaten pada dropdown spinner
    public void addOnSpinnerKabupaten() {
        List<String> kabupatenList = new ArrayList<>();
        List<DataAcuan> fertilizers = database.getAllDataAcuan();
        String previous = "";
        for (DataAcuan cn : fertilizers) {
            if (!previous.equalsIgnoreCase(cn.getKabupaten())) kabupatenList.add(cn.getKabupaten());
            previous = cn.getKabupaten();
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kabupatenList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kabupaten.setAdapter(dataAdapter);
    }

    /**
     * <p>Menambahkan daftar kecamatan pada dropdown spinner</p>
     */
    public void addOnSpinnerKecamatan(String text) {
        List<String> kecamatanList = new ArrayList<>();
        List<DataAcuan> fertilizers = database.getAllDataAcuan();
        for (DataAcuan cn : fertilizers) {
            if (cn.getKabupaten().equalsIgnoreCase(text)) kecamatanList.add(cn.getKecamatan());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, kecamatanList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kecamatan.setAdapter(dataAdapter);
    }

    private void addOnSpinnerUnit(Spinner spinner, String[] unitText) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unitText);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    /**
     * <p>Mengambil data activity_pupuk di database SQLite</p>
     */
    private List<Fertilizer> getFertilizer() {
        List<DataPupuk> dataPupuk = database.getAllDataPupuk();
        List<Fertilizer> fertilizerList = new ArrayList<>();
        for (DataPupuk f : dataPupuk) {
            fertilizerList.add(new Fertilizer(
                    f.getNama(),
                    f.getKadarN(),
                    f.getKadarP(),
                    f.getKadarK(),
                    f.getHarga())
            );

        }
        return fertilizerList;
    }

    public void proses() {

        // local var
        double valTarget = Double.valueOf(target.getText().toString());
        double valLuasTanah = Double.valueOf(luasTanah.getText().toString());
        double cr = Double.valueOf(crossoverRate.getText().toString());
        double mr = Double.valueOf(mutationRate.getText().toString());
        double n = 0;
        double p = 0;
        double k = 0;
        int generationCount = Integer.valueOf(generasi.getText().toString());
        int ps = Integer.valueOf(popSize.getText().toString());

        // mendapatkan kandungan npk berdasarkan kecamatan
        List<DataAcuan> fertilizers = database.getAllDataAcuan();
        for (DataAcuan cn : fertilizers) {
            if (cn.getKecamatan().equalsIgnoreCase(selectedKecamatan)) {
                n = cn.getNitrogen();
                p = cn.getPhosphorus();
                k = cn.getPotassium();
                System.out.println(n + " " + p + " " + k);

                // menyimpan data kandungan
                MainActivity.dataHasil.setN(n);
                MainActivity.dataHasil.setP(p);
                MainActivity.dataHasil.setK(k);

            }
        }

        final List<Fertilizer> fertilizerList = this.getFertilizer();
        final SettingImpl setting = new SettingImpl();

        // setting for genetic algorithm
        setting.setGenerationCount(generationCount);
        setting.setIndividualWindow(5);
        setting.setCrossoverRate(cr);
        setting.setMutationRate(mr);
        setting.setPopulationSize(ps);
        setting.setCutPoint(3);
        setting.putFactor("nitrogen", NUTRISI_NITROGEN);
        setting.putFactor("phosphorus", NUTRISI_PHOSPHORUS);
        setting.putFactor("potassium", NUTRISI_POTASSIUM);

        final CornPlantation plantation = new CornPlantation(n, p, k, new PlantationScale(AreaDensityUnit.TONNE_PER_HECTARE, 10.0, 1));
        ga = new GeneticsAlgorithmImpl(setting, plantation, new PlantationScale(
                getDensityUnit(selectedUnitTarget, selectedUnitLuasTanah),
                Double.parseDouble(target.getText().toString()),
                Double.parseDouble(luasTanah.getText().toString())));

        ga.setFertilizers(fertilizerList);
        ga.run();
        for (final IndividualImpl individual : ga.getParent()) {
            System.out.println(individual);
        }
        System.out.println("=== best");
        System.out.println(ga.getBest());

        MainActivity.dataHasil.setDataPupuk(fertilizerList);
        MainActivity.dataHasil.setGeneticsAlgorithm(ga);
        MainActivity.dataHasil.setKecamatan(selectedKecamatan);

        MainActivity.dataHasil.setTarget(valTarget);
        MainActivity.dataHasil.setUnitTarget(selectedUnitTarget);

        MainActivity.dataHasil.setLuasTanah(valLuasTanah);
        MainActivity.dataHasil.setUnitLuasTanah(selectedUnitLuasTanah);


    }

    /**
     * <p>Menentukan skala yang akan digunakan berdasarkan pilihan dari pengguna.</p>
     * @param unitTarget  skala untuk target pupuk berupa TON / KG
     * @param unitLuasTanah skala untuk luas tanah berupa Hektar / Meter Persegi
     */
    private AreaDensityUnit getDensityUnit(String unitTarget, String unitLuasTanah) {
        AreaDensityUnit unit;
        if (unitTarget.equals(UNIT_TARGET_KG) && unitLuasTanah.equals(UNIT_LUAS_TANAH_HA) ) {
            unit = AreaDensityUnit.KILOGRAM_PER_HECTARE;

        } else if (unitTarget.equals(UNIT_TARGET_KG) && unitLuasTanah.equals(UNIT_LUAS_TANAH_METER)) {
            unit = AreaDensityUnit.KILOGRAM_PER_SQUARE_METER;

        } else if (unitTarget.equals(UNIT_TARGET_TON) && unitLuasTanah.equals(UNIT_LUAS_TANAH_METER)) {
            unit = AreaDensityUnit.TONNE_PER_SQUARE_METER;

        } else {
            unit =  AreaDensityUnit.TONNE_PER_HECTARE;
        }
        return unit;

    }
}


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
