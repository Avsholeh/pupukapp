package com.arik.pupukapp.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "db_pupuk_app";

    static final String TABLE_DATA_ACUAN = "data_acuan";
    static final String TABLE_DATA_PUPUK = "data_pupuk";

    // data activity_rekomendasi columns names
    private static final String KEY_ACUAN_ID = "id";
    private static final String KEY_KABUPATEN = "kabupaten";
    private static final String KEY_KECAMATAN = "kecamatan";
    private static final String KEY_NITROGEN = "nitrogen";
    private static final String KEY_PHOSPHORUS = "phosphorus";
    private static final String KEY_POTASSIUM = "potassium";

    // data activity_pupuk columns names
    private static final String KEY_PUPUK_ID = "id";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_KADAR_N = "n";
    private static final String KEY_KADAR_P = "p";
    private static final String KEY_KADAR_K = "k";
    private static final String KEY_HARGA = "harga";

    // create table query
    private static final String CREATE_TABLE_DATA_ACUAN = "CREATE TABLE " + TABLE_DATA_ACUAN + "("
            + KEY_ACUAN_ID + " INTEGER PRIMARY KEY,"
            + KEY_KABUPATEN + " TEXT,"
            + KEY_KECAMATAN + " TEXT,"
            + KEY_NITROGEN + " INTEGER,"
            + KEY_PHOSPHORUS + " INTEGER,"
            + KEY_POTASSIUM + " INTEGER)";

    private static final String CREATE_TABLE_DATA_PUPUK = "CREATE TABLE " + TABLE_DATA_PUPUK + "("
            + KEY_PUPUK_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAMA + " TEXT,"
            + KEY_KADAR_N + " DOUBLE,"
            + KEY_KADAR_P + " DOUBLE,"
            + KEY_KADAR_K + " DOUBLE,"
            + KEY_HARGA + " DOUBLE)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DATA_ACUAN);
        db.execSQL(CREATE_TABLE_DATA_PUPUK);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA_ACUAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA_PUPUK);
        onCreate(db);
    }

    // adding data
    public void addDataAcuan(DataAcuan DataAcuan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_KABUPATEN, DataAcuan.getKabupaten());
        values.put(KEY_KECAMATAN, DataAcuan.getKecamatan());
        values.put(KEY_NITROGEN, DataAcuan.getNitrogen());
        values.put(KEY_PHOSPHORUS, DataAcuan.getPhosphorus());
        values.put(KEY_POTASSIUM, DataAcuan.getPotassium());

        // inserting Row
        db.insert(TABLE_DATA_ACUAN, null, values);
        db.close();
    }

    public void addDataPupuk(DataPupuk dataPupuk) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, dataPupuk.getNama());
        values.put(KEY_KADAR_N, dataPupuk.getKadarN());
        values.put(KEY_KADAR_P, dataPupuk.getKadarP());
        values.put(KEY_KADAR_K, dataPupuk.getKadarK());
        values.put(KEY_HARGA, dataPupuk.getHarga());

        // inserting row
        db.insert(TABLE_DATA_PUPUK, null, values);
        db.close();
    }

    // get data by id
    public DataAcuan getDataAcuan(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DATA_ACUAN,
                new String[] { KEY_ACUAN_ID, KEY_KABUPATEN, KEY_KECAMATAN, KEY_NITROGEN, KEY_PHOSPHORUS, KEY_POTASSIUM },
                KEY_ACUAN_ID + "=?",
                new String[] { String.valueOf(id) },
                null, null, null, null);

        if (cursor != null) cursor.moveToFirst();

        DataAcuan dataAcuan = new DataAcuan(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                Integer.parseInt(cursor.getString(3)),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)));
        cursor.close();
        return dataAcuan;
    }

    public DataPupuk getDataPupuk(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DATA_PUPUK,
                new String[] { KEY_ACUAN_ID, KEY_NAMA, KEY_KADAR_N, KEY_KADAR_P, KEY_KADAR_K, KEY_HARGA},
                KEY_PUPUK_ID + "=?",
                new String[] { String.valueOf(id) },
                null, null, null, null);

        if (cursor != null) cursor.moveToFirst();

        DataPupuk dataPupuk = new DataPupuk(
                cursor.getString(0),
                Double.parseDouble(cursor.getString(1)),
                Double.parseDouble(cursor.getString(2)),
                Double.parseDouble(cursor.getString(3)),
                Double.parseDouble(cursor.getString(4)));
        cursor.close();
        return dataPupuk;
    }

    public List<DataAcuan> getAllDataAcuan() {
        List<DataAcuan> fertilizerList = new ArrayList<DataAcuan>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DATA_ACUAN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataAcuan fertilizer = new DataAcuan();
                fertilizer.setId(Integer.parseInt(cursor.getString(0)));
                fertilizer.setKabupaten(cursor.getString(1));
                fertilizer.setKecamatan(cursor.getString(2));
                fertilizer.setNitrogen(Integer.parseInt(cursor.getString(3)));
                fertilizer.setPhosphorus(Integer.parseInt(cursor.getString(4)));
                fertilizer.setPotassium(Integer.parseInt(cursor.getString(5)));
                // Adding contact to list
                fertilizerList.add(fertilizer);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return contact list
        return fertilizerList;
    }

    public List<DataPupuk> getAllDataPupuk() {
        List<DataPupuk> dataPupukList = new ArrayList<DataPupuk>();
        // select all query
        String selectQuery = "SELECT  * FROM " + TABLE_DATA_PUPUK;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataPupuk dataPupuk = new DataPupuk();
                dataPupuk.setId(Integer.parseInt(cursor.getString(0)));
                dataPupuk.setNama(cursor.getString(1));
                dataPupuk.setKadarN(Integer.parseInt(cursor.getString(2)));
                dataPupuk.setKadarP(Integer.parseInt(cursor.getString(3)));
                dataPupuk.setKadarK(Integer.parseInt(cursor.getString(4)));
                dataPupuk.setHarga(Integer.parseInt(cursor.getString(5)));
                dataPupukList.add(dataPupuk);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return dataPupukList;
    }

    public int updateDataAcuan(DataAcuan DataAcuan) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_KABUPATEN, DataAcuan.getKabupaten());
        values.put(KEY_KECAMATAN, DataAcuan.getKecamatan());
        values.put(KEY_NITROGEN, DataAcuan.getNitrogen());
        values.put(KEY_PHOSPHORUS, DataAcuan.getPhosphorus());
        values.put(KEY_POTASSIUM, DataAcuan.getPotassium());

        // updating row
        return db.update(TABLE_DATA_ACUAN, values, KEY_ACUAN_ID + " = ?",
                new String[] { String.valueOf(DataAcuan.getId()) });
    }

    public int updateDataPupuk(DataPupuk dataPupuk) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, dataPupuk.getNama());
        values.put(KEY_KADAR_N, dataPupuk.getKadarN());
        values.put(KEY_KADAR_P, dataPupuk.getKadarP());
        values.put(KEY_KADAR_K, dataPupuk.getKadarK());
        values.put(KEY_HARGA, dataPupuk.getHarga());

        // updating row
        return db.update(TABLE_DATA_PUPUK, values, KEY_PUPUK_ID + " = ?", new String[] { String.valueOf(dataPupuk.getId()) });
    }

    public void deleteDataAcuan(DataAcuan dataAcuan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DATA_ACUAN, KEY_ACUAN_ID + " = ?",
                new String[] { String.valueOf(dataAcuan.getId()) });
        db.close();
    }

    public int deleteDataPupuk(DataPupuk dataPupuk) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TABLE_DATA_PUPUK, KEY_ACUAN_ID + " = ?",
                new String[] { String.valueOf(dataPupuk.getId()) });
        db.close();
        return result;
    }

    public int getJumlahDataAcuan() {
        String countQuery = "SELECT  * FROM " + TABLE_DATA_ACUAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getJumlahDataPupuk() {
        String countQuery = "SELECT  * FROM " + TABLE_DATA_PUPUK;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public static boolean doesDatabaseExist(Context context) {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.exists();
    }


    public static void deleteDatabase(Context context) {
        if (doesDatabaseExist(context)) context.deleteDatabase(DATABASE_NAME);
    }
}