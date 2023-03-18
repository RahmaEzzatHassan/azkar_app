package com.example.azkar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class MwaqetActivity extends AppCompatActivity {
    TextView F,Sh,D,As,M,Esh;
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwaqet);
        getSupportActionBar().hide();
        F =(TextView)findViewById(R.id.time_fajer);
        Sh =(TextView)findViewById(R.id.time_sunrise);
        D =(TextView)findViewById(R.id.time_dhuhr);
        As =(TextView)findViewById(R.id.time_asr);
        M =(TextView)findViewById(R.id.time_maghrib);
        Esh =(TextView)findViewById(R.id.time_ishaa);




        String url1 = "https://api.aladhan.com/v1/timingsByCity?city="+MainActivity.cityName+"&country="+MainActivity.countryName+"&method=8";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObject value = new JsonObject();
        JsonObjectRequest objectRequest =  new JsonObjectRequest(
                Request.Method.GET, url1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String JSON_STRING = response.toString();

                        JSONObject obj = null;
                        JSONObject times = new JSONObject();
                        JSONObject data = new JSONObject();
                        try {
                            obj = new JSONObject(JSON_STRING);
                            data = obj.getJSONObject("data");
                            times = data.getJSONObject("timings");
                            String FT = times.getString("Fajr");
                            F.setText(FT);
                            String Sr = times.getString("Sunrise");
                            Sh.setText(Sr);
                            String dh = times.getString("Dhuhr");
                            D.setText(dh);
                            String asr = times.getString("Asr");
                            As.setText(asr);
                            String m = times.getString("Maghrib");
                            M.setText(m);
                            String s = times.getString("Isha");
                            Esh.setText(s);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }}
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MwaqetActivity.this,"من فضلك تأكد من الاتصال بالانترنت", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(objectRequest);



    }
    public void toHomeFromMwq(View v){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }


}



