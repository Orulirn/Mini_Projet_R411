package com.example.mini_projet_r411.Model;

import android.content.Context;

import com.example.mini_projet_r411.Managers.NotesHandler;

import java.util.ArrayList;

public class LesNotes {
    private ArrayList<Notes> notes;
    static private LesNotes monInstance = null;
    private Context mContext;
    private LesNotes(Context context){
        this.mContext = context;
        this.notes = getAllNotes();
    }

    public static LesNotes getInstance(Context context){
        if (monInstance == null){
            monInstance = new LesNotes(context);
        }
        return monInstance;
    }

    private ArrayList<Notes> getAllNotes(){
        //implementation BDD si possible
        //return this.notes;
        this.notes = (ArrayList<Notes>) new NotesHandler(mContext).getAllNotes();
        return this.notes;

    }

    public Notes findById(int i){
        for(Notes n : this.notes){
            if (n.getId() == i){
                return n;
            }
        }
        return null;
    }




    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void ajoutNote(Notes note) {
        this.notes.add(note);
    }
    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
    }
}
