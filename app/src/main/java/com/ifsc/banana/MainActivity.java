package com.ifsc.banana;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity{

    LocationManager locationManager;
    TextView res, res2;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.res);
        res2 = findViewById(R.id.res2);
        btn = findViewById(R.id.butto);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        btn.setOnClickListener(v->getLocalizacao());

    }

    public void getLocalizacao(){
        if((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION))!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},1);
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location!=null){
            res.setText(Double.toString(location.getLatitude()));
            res2.setText(Double.toString(location.getLongitude()));
        }else{
            res.setText("Erro ao achar latitude");
            res2.setText("Erro ao achar longitude");
        }

    }



}