package com.example.mini_projet_r411.Managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mini_projet_r411.Model.Notes;

import java.util.ArrayList;
import java.util.List;

public class NotesHandler extends SQLiteHelper{
    private SQLiteHelper dbHelper;
    public NotesHandler(Context context){
        super(context);
        dbHelper = new SQLiteHelper(context);
    }

    public int addNotes(Notes note){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbHelper.KEY_TITlE, note.getTitre());
        values.put(dbHelper.KEY_BODY, note.getBody());
        long insertId = db.insert(dbHelper.TABLE_NOTE,null,values);
        db.close();
        return (int)insertId;
    }

    public Notes getNotes(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(dbHelper.TABLE_NOTE,
                new String[] {dbHelper.KEY_ID,dbHelper.KEY_TITlE,dbHelper.KEY_BODY},
                dbHelper.KEY_ID+ "=?", new String[] {String.valueOf(id)}, null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        Notes note = new Notes(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return note;
    }

    public List<Notes> getAllNotes(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Notes> listDeNotes = new ArrayList<Notes>();
        String selectQuery = "SELECT * FROM " + dbHelper.TABLE_NOTE;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do {
                Notes note = new Notes(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                listDeNotes.add(note);
            } while (cursor.moveToNext());
        }
        return listDeNotes;
    }

    public int updateNotes(Notes note){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbHelper.KEY_TITlE, note.getTitre());
        values.put(dbHelper.KEY_BODY, note.getBody());
        long updateId=db.update(dbHelper.TABLE_NOTE,values,dbHelper.KEY_ID + " = ?", new String[]{String.valueOf(note.getId())});
        db.close();
        return (int) updateId;
    }
}
