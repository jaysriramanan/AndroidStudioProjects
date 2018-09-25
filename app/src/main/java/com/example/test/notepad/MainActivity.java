package com.example.test.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.test.notepad.Adapters.NoteAdapter;
import com.example.test.notepad.Model.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Note> notes=new ArrayList<>();
    static final int ADD_NOTE_REQUEST=1;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.notesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //this.notes=new ArrayList<>();
        loadNotes();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewNote();
            }
        });

    }

    private void loadNotes(){
        if(notes.size()!=0) {
            noteAdapter = new NoteAdapter(this, notes);
            recyclerView.setAdapter(noteAdapter);
        }
        else{
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("No notes to display. Create a new note!");
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }

    }

    private void addNewNote(){

        Intent addNewNote=new Intent(this,AddNote.class);
        startActivityForResult(addNewNote,ADD_NOTE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent getNewNote){
        super.onActivityResult(requestCode, resultCode, getNewNote);
        if(requestCode==ADD_NOTE_REQUEST) {
            if (resultCode == RESULT_OK) {
                String[] newNote =getNewNote.getStringArrayExtra("newNote");
                notes.add(new Note(newNote[0],newNote[1]));
            }
        }
        if(noteAdapter!=null){
            noteAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }
}
