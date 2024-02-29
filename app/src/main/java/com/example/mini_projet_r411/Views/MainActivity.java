package com.example.mini_projet_r411.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.example.mini_projet_r411.Model.LesNotes;
import com.example.mini_projet_r411.Model.Notes;
import com.example.mini_projet_r411.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private List<Notes> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LesNotes ln = LesNotes.getInstance();

        if (ln.getNotes() == null){
            noteList = new ArrayList<>();
            noteList.add(new Notes(1, "Titre 1", "Contenu de la note 1"));
            noteList.add(new Notes(2, "Titre 2", "Contenu de la note 2"));
            noteList.add(new Notes(3, "Titre 3", "Contenu de la note 3"));
        } else{
            noteList = ln.getNotes();
        }

        adapter = new NoteAdapter(noteList);
        recyclerView.setAdapter(adapter);
    }


    private void ChangeActivityModifyNotes(){
        //TODO ajouter la fonctionnalité de modification de note
    }

    public void changeActivityAddNote(View view) {
        Intent intent = new Intent(this, AddNotes.class);

        startActivity(intent);
    }
}