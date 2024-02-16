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
        return new ArrayList<>();
    }


}
