package com.example.azkar;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static String cityName;
    public static String countryName;
    private TextView dateTimeDisplay,Time;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    String arr[]=new String[12];
    private String date;
    private int year=0;
    private int month=0;
    private int day=0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"NewApi", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        Time=findViewById(R.id.textTime);
        DateFormat timeformat=new SimpleDateFormat("h:mm a", new Locale("ar"));
        String time= timeformat.format(new Date());
        Time.setText(time);


        //هنا بنجيب التاريخ الميلادي
        dateTimeDisplay = (TextView)findViewById(R.id.taqueem);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        // date=calendar.getTime().toString();\\

        // التاريخ بيرجع في صورة استرينج محتاجين نحوله لانتجر عشان نبعته للفانكشن الي هتحول الميلادي للعربي
        String mon_str=date.substring(0,2);
        try{
            month = Integer.parseInt(mon_str);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }



        String day_str = date.substring(3,5);
        try{
            day = Integer.parseInt(day_str);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        //day=date.substring(4,6);
        String year_str = date.substring(6);
        try{
            year = Integer.parseInt(year_str);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        final LocalDate datee = LocalDate.of(year, month, day);

        final LocalDate muslimDate = toMuslim(datee);

// هنا احنا خلاص جبنا التاريخ العربي بس محتاجين نحول الشهر من مجرد رقم لاسم الشهر ذات نفسه
        String printed_year=muslimDate.toString().substring(0,4);
        String printed_month=muslimDate.toString().substring(5,7);
        String printed_day=muslimDate.toString().substring(8);

        int ar_month=0;
        try{
            ar_month = Integer.parseInt(printed_month);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }



        //for converting month


        arr[0]="محرم";
        arr[1]="صفر";
        arr[2]="ربيع اول";
        arr[3]="ربيع اخر";
        arr[4]="جمادى الاولى";
        arr[5]="جمادى الاخرة";
        arr[6]="رجب";
        arr[7]="شعبان";
        arr[8]="رمضان";
        arr[9]="شوال";
        arr[10]="ذو القعدة";
        arr[11]="ذو الحجة";



        //System.out.println(String.format("%s <- Converted to Muslim.", muslimDate));

        //dateTimeDisplay.setText(date);
        dateTimeDisplay.setText(printed_day+" "+arr[ar_month-1]+" "+printed_year);
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // user defines the criteria
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);   //default
        criteria.setCostAllowed(false);
        // get the best provider depending on the criteria
        String provider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.
                checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            //bla
            int REQUEST_LOCATION = 99;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]
                    {ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }

        final Location location = locationManager.getLastKnownLocation(provider);
        MyLocationListener mylistener = new MyLocationListener();
        if (location != null) {

            mylistener.onLocationChanged(location);
        } else {
            // leads to the settings because there is no last known location
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
            //Using 12 seconds timer till it gets location
            final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Obtaining Location ...");
            alertDialog.setMessage("00:12");
            alertDialog.show();

            new CountDownTimer(12000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    alertDialog.setMessage("00:" + (millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                    alertDialog.dismiss();
                }
            }.start();
        }

        if (ActivityCompat.checkSelfPermission(MainActivity.this, ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // this will beautomatically asked to be implemented
        }
        locationManager.requestLocationUpdates(provider, 200, 1, mylistener);
        if (location != null) {
            double lat = location.getLatitude();
            double lon = location.getLongitude();

            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
            List<Address> addresses = null;
            try {
                addresses = geocoder.getFromLocation(lat, lon, 2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            cityName = addresses.get(1).getLocality();

            countryName = addresses.get(1).getCountryName();}
        else {
            Toast.makeText(MainActivity.this, "من فضلك اسمح لنا بالوصول الى موقعك", Toast.LENGTH_LONG).show();
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static LocalDate toMuslim(LocalDate gregorianDate) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String hijrahDateString = HijrahChronology.INSTANCE.date(gregorianDate).format(formatter);

        return LocalDate.parse(hijrahDateString, formatter);
    }
    public static class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {}}
    public void compass(View v){
        Intent intent = new Intent(this, CompassActivity.class);

        intent.putExtra(Constants.TOOLBAR_TITLE, "");		// Toolbar Title
        intent.putExtra(Constants.TOOLBAR_BG_COLOR, "#00FFFFFF");		// Toolbar Background color
        intent.putExtra(Constants.TOOLBAR_TITLE_COLOR, "#000000");	// Toolbar Title color
        intent.putExtra(Constants.COMPASS_BG_COLOR, "#F1EEE4");		// Compass background color
        intent.putExtra(Constants.ANGLE_TEXT_COLOR, "#000000");		// Angle Text color
        intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial);	// Your dial drawable resource
        intent.putExtra(Constants.DRAWABLE_QIBLA, R.drawable.qibla); 	// Your qibla indicator drawable resource
        intent.putExtra(Constants.FOOTER_IMAGE_VISIBLE, View.INVISIBLE);	// Footer World Image visibility
        intent.putExtra(Constants.LOCATION_TEXT_VISIBLE, View.INVISIBLE); // Location Text visibility

        startActivity(intent);
    }
    public void mwaqeet(View v){
        Intent mwaqeet = new Intent(this, MwaqetActivity.class);
        startActivity(mwaqeet);
    }

    public void azkar(View v){
        Intent azkar = new Intent(this, AzkarActivity.class);
        startActivity(azkar);
    }

    public void Quran(View v){
        Intent Quran = new Intent(this, QuranActivity.class);
        startActivity(Quran);
    }

    public void mesbaha(View v){
        Intent mesbaha = new Intent(this, Msb7aActivity.class);
        startActivity(mesbaha);
    }

    public void quiz(View v){
        Intent quiz = new Intent(this, QuizActivity.class);
        startActivity(quiz);
    }












}