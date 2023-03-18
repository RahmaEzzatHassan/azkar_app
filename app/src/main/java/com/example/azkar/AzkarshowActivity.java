package com.example.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;

public class AzkarshowActivity extends AppCompatActivity {
    static int id = 0;
    int Azkarmax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkarshow);
        getSupportActionBar().hide();

        Intent i = getIntent();
        String title = i.getStringExtra("type");
        Button button =  (Button)findViewById(R.id.buttontittle);
        button.setText(title);
        TextView textView = (TextView) findViewById(R.id.Content);
        Log.d("Morning",title);
        String data ="";
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray userArray = obj.getJSONArray(title);
            Azkarmax=userArray.length();
            String info = String.valueOf(userArray);
            Log.d("Try",info);
            data = String.valueOf(userArray.getJSONObject(id).get("content"));
            data= data.replace("\\", "");
            data = data.replaceAll("n","");
            data = data.replaceAll("\"","");
            data = data.replaceAll(",","");
            data = data.replaceAll("\'","");
            textView.setText(data);


        } catch (JSONException e) {
            e.printStackTrace();
            id = 0;

        }
        //String x = "Max"+Azkarmax+"Current"+id;
        //Log.d("ma",x);


    }
    public  void next(View v){
        if(id==(Azkarmax-1)){
            Button b= (Button) v;
            b.setEnabled(false);
        }else {
            id++;
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            recreate();
        }
    }
    public void previous(View v){
        if(id==0){
            Button button =(Button) v;
            button.setEnabled(false);
        }else{
            id--;
            finish();
            overridePendingTransition(0, 0);
            startActivity(getIntent());
            overridePendingTransition(0, 0);
            recreate();
        }
    }
    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("azkar.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
