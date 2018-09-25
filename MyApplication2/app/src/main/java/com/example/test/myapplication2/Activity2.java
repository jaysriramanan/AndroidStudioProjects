package com.example.test.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textView1=(TextView)findViewById(R.id.TextView1);
        String text="hello "+getIntent().getStringExtra("name");
        textView1.setText(text);
    }
    public void gotoMain(View view)
    {
        Intent prevPage=new Intent();
        EditText editText1=(EditText)findViewById(R.id.editText1);
        String text1 = editText1.getText().toString();
        prevPage.putExtra("message ",text1);
        setResult(Activity.RESULT_OK,prevPage);
        //prevPage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(prevPage);
        finish();
    }
}
