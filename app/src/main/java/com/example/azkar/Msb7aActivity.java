package com.example.azkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Msb7aActivity extends AppCompatActivity {
    private int nCycle;
    private int nScore;
    private int nCounter;
    public int i=0;
    Button reseter;
    TextView count;
    TextView score;
    TextView cycle;
    Button counter;
    TextView say;
    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msb7a);
        getSupportActionBar().hide();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        SharedPreferences mPrefsCount = getSharedPreferences("savedCount",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorC= mPrefsCount.edit();
        SharedPreferences mPrefsScore = getSharedPreferences("savedScore",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorS= mPrefsScore.edit();
        SharedPreferences mPrefsCycle = getSharedPreferences("savedCycle",Context.MODE_PRIVATE);
        SharedPreferences.Editor editorCy= mPrefsCycle.edit();

        counter = (Button)findViewById(R.id.counter_button);
        count = (TextView)findViewById(R.id.seb7atext);
        score = (TextView)findViewById(R.id.score_n);
        cycle = (TextView)findViewById(R.id.cycle_n);
        reseter = (Button)findViewById(R.id.reset_button);
        say = (TextView) findViewById(R.id.say);
        score.setText(mPrefsScore.getString("savedScore","0"));
        cycle.setText(mPrefsCycle.getString("savedCycle","0"));
        count.setText(mPrefsCount.getString("savedCount", "0"));
        List<String> tsbeeh = new ArrayList<String>();
        tsbeeh.add("سبحان الله");tsbeeh.add("الحمدلله");tsbeeh.add("لا اله إلا الله");
        tsbeeh.add("الله أكبر");tsbeeh.add("أستغفر الله");tsbeeh.add("سبحان الله");
        tsbeeh.add("رب اغفر لي");tsbeeh.add("لا حول \nولا قوة إلا بالله");
        say.setText(tsbeeh.get(i));
        reseter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "إضغط مطولا لمحو المجموع" , Toast.LENGTH_SHORT ).show();
                v.vibrate(400);
            nCounter = 0;
            nCycle = 0;
                count.setText("0");
                cycle.setText("0");
                editorCy.clear();
                editorCy.commit();
                editorC.clear();
                editorC.commit();
            }
        });
        reseter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                nCounter = 0;
                nCycle = 0;
                count.setText("0");
                cycle.setText("0");
                editorCy.clear();
                editorCy.commit();
                editorC.clear();
                editorC.commit();
                nScore = 0;
                score.setText("0");
                editorS.clear();
                editorS.commit();
                Vibrator v2 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                v2.vibrate(500);
                return true;
            }
        });


        counter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nCycle = Integer.parseInt(mPrefsCycle.getString("savedCycle", "0"));
                nScore = Integer.parseInt(mPrefsScore.getString("savedScore", "0"))+1;
                nCounter = Integer.parseInt(mPrefsCount.getString("savedCount", "0"))+1;

                if (nCounter % 33 == 0) {
                    v.vibrate(250);
                    i++;
                    say.setText(tsbeeh.get(i));
                    say.setTextSize(30);
                    if (i == 7){say.setTextSize(15);i=0;}
                    nCycle = Integer.parseInt(mPrefsCycle.getString("savedCycle", "0"))+1;
                    if(nCycle % 8 == 0){
                        Toast.makeText(getBaseContext(), "تقبل الله" , Toast.LENGTH_SHORT ).show();
                        v.vibrate(350);}
                }
                count.setText(String.valueOf(nCounter));
                cycle.setText(String.valueOf(nCycle));
                score.setText(String.valueOf(nScore));
                editorC.putString("savedCount", String.valueOf(nCounter));
                editorC.commit();
                editorCy.putString("savedCycle", String.valueOf(nCycle));
                editorCy.commit();
                editorS.putString("savedScore", String.valueOf(nScore));
                editorS.commit();


            }
        });

    }

    public void toHomeFromMsb7a(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);}
}