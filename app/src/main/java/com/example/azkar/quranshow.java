package com.example.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class quranshow extends AppCompatActivity {
    public static String  SURASHOW,Surashow;
    TextView surashow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quranshow);
        getSupportActionBar().hide();
        surashow=(TextView) findViewById(R.id.suratextView);
        Intent i=getIntent();
        Surashow=i.getStringExtra(SURASHOW);
        surashow.setText(Surashow);


    }
    public void toHomeFromQuranshow(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}

