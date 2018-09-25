package com.example.test.notepad;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNote extends AppCompatActivity implements View.OnClickListener {

    EditText title,content;
    Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        addNote=(Button) findViewById(R.id.addNote);
        addNote.setOnClickListener(AddNote.this);
    }

    @Override
    public void onClick(View view) {
        title=(EditText)findViewById(R.id.Title);
        content=(EditText)findViewById(R.id.Content);
        String noteTitle=title.getText().toString();
        String noteContent=content.getText().toString();
        String[] extras={noteTitle,noteContent};
        Intent noteAdded=new Intent();
        noteAdded.putExtra("newNote",extras);
        setResult(Activity.RESULT_OK,noteAdded);
        finish();

    }

}
