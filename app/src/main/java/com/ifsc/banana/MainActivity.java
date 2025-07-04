package com.ifsc.banana;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.config.Configuration;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    Location location;
    TextView res, res2;
    MapView map;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.res);
        res2 = findViewById(R.id.res2);
        btn = findViewById(R.id.butto);
        map = findViewById(R.id.mapView);

        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                track = false;
                return false;
            }
        });

        Configuration.getInstance().setUserAgentHttpHeader(getPackageName());
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        btn.setOnClickListener(v->getLocalizacao());

    }

    public void getLocalizacao() {
        if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListner);
    }

    boolean track = true;
    public void showlocalizacao(double latitude, double longitude) {
        GeoPoint userLoc = new GeoPoint(latitude, longitude);
        Marker marker = new Marker(map);
        marker.setPosition(userLoc);
        marker.setTitle("Estamos aqui");

        map.getOverlays().clear();
        if(track){
            map.getController().setCenter(userLoc);
        }
        map.getController().setZoom(18.8);
        map.getOverlays().add(marker);
        map.invalidate();


    }

    public final LocationListener locationListner = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            res.setText(Double.toString(location.getLatitude()));
            res2.setText(Double.toString(location.getLongitude()));
            showlocalizacao(location.getLatitude(), location.getLongitude());
        }
    };

}


