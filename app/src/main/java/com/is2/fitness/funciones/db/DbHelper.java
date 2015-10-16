package com.is2.fitness.funciones.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USUARIO on 14/10/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "olimpo.sqlite";
    public static final int DB_SCHEME_VERSION = 1;


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseManager.CREATE_CP);
        db.execSQL(DatabaseManager.CREATE_E);
        db.execSQL(DatabaseManager.CREATE_M);
        db.execSQL(DatabaseManager.CREATE_P);
        db.execSQL(DatabaseManager.CREATE_S);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
