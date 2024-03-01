package com.example.mini_projet_r411.Managers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "miniProjetR411";
    protected static final String TABLE_NOTE = "notes";
    public static final String KEY_ID = "id";
    public static final String KEY_TITlE = "title";
    public static final String KEY_BODY = "body";
    //Notes
    //--- id
    //--- title
    //--- body

    public SQLiteHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + TABLE_NOTE + " (" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITlE + " TEXT," + KEY_BODY + " TEXT )";
        db.execSQL(CREATE_NOTES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }

}
