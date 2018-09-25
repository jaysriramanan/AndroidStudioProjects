package com.example.test.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class displayNote extends AppCompatActivity implements View.OnClickListener {
    private TextView title,content;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_note);
        title=(TextView)findViewById(R.id.displayTitle);
        content=(TextView)findViewById(R.id.displayContent);
        back=(Button)findViewById(R.id.backButton);
        String[] disNote=getIntent().getStringArrayExtra("note");
        title.setText(""+disNote[0]);
        content.setText(""+disNote[1]);
        back.setOnClickListener(displayNote.this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
