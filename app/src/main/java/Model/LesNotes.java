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

    private static ArrayList<Notes> getAllNotes(){
        //TODO
        return new ArrayList<Notes>();
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
