package com.example.mini_projet_r411.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;


import com.example.mini_projet_r411.Managers.NotesHandler;
import com.example.mini_projet_r411.Model.LesNotes;
import com.example.mini_projet_r411.Model.Notes;
import com.example.mini_projet_r411.R;

public class AddNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
    }


    public void ChangeActivitygobackmain(View view) {
        EditText textView = (EditText) findViewById(R.id.titreInput);
        EditText textView2 = (EditText)  findViewById(R.id.editTextTextMultiLine);
        String contenttitre =textView.getText().toString();
        String contentBody = textView2.getText().toString();
        LesNotes lnotes = LesNotes.getInstance(view.getContext());
        Notes n = new Notes(lnotes.getNotes().size()+1, contenttitre, contentBody);
        try {
            int id = new NotesHandler(view.getContext()).addNotes(n);
        }catch (Exception e){
            System.out.println(e);
        }

        lnotes.getNotes().add(n);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }

    public void ChangeActivityAbort(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}