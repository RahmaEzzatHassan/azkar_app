package com.example.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class QuranActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        getSupportActionBar().hide();

    }

    public String loadJSONfromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("quran (1).json");
            /*int size=is.available();
            byte buffer[]=new byte[size];
            is.read(buffer);
            is.close();
            json=new String(buffer);*/
            StringBuilder buf = new StringBuilder();
            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
            json = buf.toString();
            /*String base64=Base64.encodeToString(json.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);
            byte[] decrypt=Base64.decode(base64,Base64.DEFAULT);
            json =new String(decrypt,"UTF-8");*/

            Log.d("json",json);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public void sura1(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("1");
        //Toast.makeText(this, sura2.toString(), Toast.LENGTH_SHORT).show();
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura2(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("2");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura3(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("3");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura4(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("4");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura5(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("5");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura6(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("6");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura7(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("7");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura8(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("8");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura9(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("9");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura10(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("10");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura11(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("11");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura12(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("12");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura13(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("13");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura14(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("14");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura15(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("15");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura16(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("16");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura17(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("17");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura18(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("18");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura19(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("19");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura20(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("20");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura21(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("21");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura22(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("22");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura23(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("23");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura24(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("24");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura25(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("25");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura26(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("26");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura27(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("27");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura28(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("28");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura29(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("29");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura30(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("30");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura31(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("31");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura32(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("32");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura33(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("33");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura34(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("34");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura35(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("35");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura36(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("36");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura37(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("37");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura38(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("38");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura39(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("39");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura40(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("40");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura41(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("41");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura42(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("42");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura43(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("43");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura44(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("44");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura45(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("45");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura46(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("46");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura47(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("47");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura48(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("48");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura49(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("49");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura50(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("50");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura51(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("51");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura52(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("52");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura53(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("53");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura54(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("54");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura55(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("55");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura56(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("56");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura57(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("57");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura58(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("58");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura59(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("59");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura60(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("60");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura61(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("61");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura62(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("62");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura63(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("63");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura64(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("64");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura65(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("65");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura66(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("66");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura67(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("67");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura68(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("68");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura69(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("69");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura70(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("70");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura71(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("71");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura72(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("72");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura73(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("73");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura74(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("74");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura75(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("75");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura76(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("76");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura77(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("77");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura78(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("78");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura79(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("79");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura80(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("80");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura81(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("81");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura82(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("82");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura83(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("83");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura84(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("84");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura85(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("85");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura86(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("86");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura87(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("87");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura88(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("88");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura89(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("89");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura90(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("90");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura91(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("91");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura92(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("92");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura93(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("93");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura94(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("94");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura95(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("95");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura96(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("96");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura97(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("97");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura98(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("98");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura99(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("99");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura100(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("100");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura101(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("101");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura102(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("102");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura103(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("103");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura104(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("104");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura105(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("105");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura106(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("106");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura107(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("107");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura108(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("108");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura109(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("109");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura110(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("110");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura111(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("111");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura112(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("112");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura113(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("113");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }

    public void sura114(View v) throws JSONException {
        Intent azkar = new Intent(this, quranshow.class);
        String sura = Suraprint("114");
        azkar.putExtra(quranshow.SURASHOW, sura.toString());
        startActivity(azkar);
    }










    public void toHomeFromAzkar(View v) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public void toHomeFromQuran(View v) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    public String Suraprint(String suranumber) throws JSONException {
        JSONObject obj = new JSONObject(loadJSONfromAssets());
        List<String> list = new ArrayList<>();
        JSONArray jsonarray = obj.getJSONArray(suranumber);
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("AR"));
        String numberofaya="";
        int r=0;
        for (int i = 0; i < jsonarray.length(); i++) {
            list.add(jsonarray.getJSONObject(i).getString("text"));
            //list.add(jsonarray.getJSONObject(i).getString("verse"));
            int n = 1;
            n += i;
            if(n%10==0&n<100){
                n=reverse(n);
                nf.setMinimumIntegerDigits(2);
            }else if(n%10==0&n>=100){
                n=reverse(n);
                nf.setMinimumIntegerDigits(3);
            }else {
                n=reverse(n);
            }
            //n = reverse(n);
            //String numberofaya=ayanumber(String.valueOf(n));
            String ayanumber = String.valueOf(nf.format(n)) + "\u06DD";
            list.add(ayanumber);
        }
        String surah = toString(list);
        return surah;
    }

    public String toString(List aya) {
        String print = "";
        for (int i = 0; i < aya.size(); i++) {
            print += (aya.get(i) + "");
        }
        return print;
    }

    public int reverse(int num) {
        int rem, rev;
        rem = 0;
        rev = 0;
        while (num > 0) {
            rem = num % 10;
            rev= rev * 10 + rem;
            num = num / 10;
        }
        return rev;

    }

}
