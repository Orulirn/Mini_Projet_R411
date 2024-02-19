package Model;

import java.util.ArrayList;

public class LesNotes {
    private ArrayList<Notes> notes;
    static private LesNotes monInstance = null;
    private LesNotes(){
        this.notes = getAllNotes();
    }

    public static LesNotes getInstance(){
        if (monInstance == null){
            monInstance = new LesNotes();
        }
        return monInstance;
    }

    private ArrayList<Notes> getAllNotes(){
        //implementation BDD si possible
        return this.notes;
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
