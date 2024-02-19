package com.example.mini_projet_r411;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void ChangeActivityAddNote(){
        Intent intent = new Intent(this, AddNotes.class);

        startActivity(intent);
    }

    private void ChangeActivityModifyNotes(){
        //TODO ajouter la fonctionnalité de modification de note
    }
}