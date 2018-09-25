package com.example.test.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView,textView2;
    private Button b1;
    private EditText editText;
    static final int MESSAGE_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked\n\n\n\n\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked\n\n\n\n\n");

    }

    protected void gotoActivity2(View v){
        editText=(EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();
        Intent nextPage = new Intent(MainActivity.this, Activity2.class);
        nextPage.putExtra("name",text);
        startActivityForResult(nextPage,MESSAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent messageFromActivity){
       super.onActivityResult(requestCode, resultCode, messageFromActivity);
        if(requestCode==MESSAGE_REQUEST){
            if(resultCode==RESULT_OK){
                textView2=(TextView)findViewById(R.id.TextView2);
                String message=messageFromActivity.getStringExtra("message ");
                textView2.setText(message);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked\n\n\n\n\n");
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v){
        editText=(EditText)findViewById(R.id.editText);
        String text = editText.getText().toString();
        Intent nextPage = new Intent(MainActivity.this, Activity2.class);
        nextPage.putExtra("name",text);
        startActivityForResult(nextPage,MESSAGE_REQUEST);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked\n\n\n\n\n");
       /* b1=(Button) findViewById(R.id.button1);
        textView=(TextView)findViewById(R.id.TextView);
        editText=(EditText)findViewById(R.id.editText);
        textView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);*/
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked\n\n\n\n\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked\n\n\n\n\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked\n\n\n\n\n");
    }

}
