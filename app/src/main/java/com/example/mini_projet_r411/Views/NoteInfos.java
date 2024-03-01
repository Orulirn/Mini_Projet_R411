package com.example.mini_projet_r411.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.mini_projet_r411.Model.LesNotes;
import com.example.mini_projet_r411.Model.Notes;
import com.example.mini_projet_r411.R;

public class NoteInfos extends AppCompatActivity {
    private int noteid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_infos);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        int id = b.getInt("note_id");
        noteid = id;
        LesNotes notes = LesNotes.getInstance(this);
        Notes n = notes.findById(id);

        EditText textView = findViewById(R.id.titreInput);
        textView.setText(n.getTitre());

        EditText textView2 = findViewById(R.id.editTextTextMultiLine);
        textView2.setText(n.getBody());

    }


    public void ChangeActivitygobackmain(View view) {
        EditText textView = (EditText) findViewById(R.id.titreInput);
        EditText textView2 = (EditText)  findViewById(R.id.editTextTextMultiLine);
        String contenttitre =textView.getText().toString();
        String contentBody = textView2.getText().toString();
        LesNotes notes = LesNotes.getInstance(this);
        Notes n = notes.findById(noteid);

        n.setTitre(contenttitre);
        n.setBody(contentBody);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }
}