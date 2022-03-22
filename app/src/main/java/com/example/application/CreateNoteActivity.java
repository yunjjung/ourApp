package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateNoteActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        ImageView imageBack=findViewById(R.id.imageBack);
        imageBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                onBackPressed();
            }
        });


        EditText NoteTitle  = (EditText)findViewById(R.id.inputNoteTitle);

        ImageView imageSave = findViewById(R.id.imageSave);
        imageSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.v("EditText", NoteTitle.getText().toString());
            }
        });
    }
}