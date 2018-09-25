package com.example.test.notepad.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.notepad.Model.Note;
import com.example.test.notepad.R;
import com.example.test.notepad.displayNote;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {

    private Context context;
    private ArrayList<Note> notes;

    public NoteAdapter(Context context, ArrayList<Note> notes) {

        this.context = context;
        this.notes = notes;
    }

    @Override
    public NoteHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(context).inflate(R.layout.note_display,viewGroup,false);
        return new NoteHolder(v);

    }

    @Override
    public void onBindViewHolder(NoteHolder holder, int position) {

        Note note=getNote(position);
        if(note!=null){

            holder.noteTitle.setText(note.getNoteTitle());
            holder.noteContent.setText(note.getNoteContent());
            final String[] disNote={holder.noteTitle.getText().toString(),holder.noteContent.getText().toString()};
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(view.getContext(),displayNote.class);
                    intent.putExtra("note",disNote);
                    view.getContext().startActivity(intent);
                }
            });

        }

    }

    @Override
    public int getItemCount(){

        return notes.size();

    }
    private Note getNote(int pos){

        return notes.get(pos);

    }

    class NoteHolder extends RecyclerView.ViewHolder{

        TextView noteTitle,noteContent;

        public NoteHolder(View itemView) {

            super(itemView);
            noteTitle=itemView.findViewById(R.id.noteTitle);
            noteContent=itemView.findViewById(R.id.noteContent);

        }

    }

}
