package com.example.azkar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private TextView score;
    private Button homebtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        score = findViewById(R.id.score_num);
        homebtn = findViewById(R.id.homeptn);
        String score_str = getIntent().getStringExtra("SCORE");
        score.setText(score_str);


    }

    public void toHomeFromScore(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        ScoreActivity.this.finish();
    }
}