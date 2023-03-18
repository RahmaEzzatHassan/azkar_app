package com.example.azkar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AzkarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);
        getSupportActionBar().hide();

    }

    public void Azkar1(View v){
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type","أذكار الصباح");
        startActivity(azkar);
    }

    public void Azkar2(View v){
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type","أذكار المساء");
        startActivity(azkar);
    }
    public void Azkar3(View v){
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type","أذكار بعد السلام من الصلاة المفروضة");
        startActivity(azkar);
    }
    public void Azkar4(View v) {
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type", "أذكار النوم");
        startActivity(azkar);
    }
    public void Azkar5(View v) {
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type", "أذكار الاستيقاظ");
        startActivity(azkar);
    }
    public void Azkar6(View v) {
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type", "أدعية قرآنية");
        startActivity(azkar);
    }
    public void Azkar7(View v) {
        Intent azkar =  new Intent(this,AzkarshowActivity.class);
        azkar.putExtra("type", "أدعية الأنبياء");
        startActivity(azkar);
    }
    public void toHomeFromAzkar(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}