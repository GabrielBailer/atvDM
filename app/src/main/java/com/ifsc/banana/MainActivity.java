package com.ifsc.banana;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView res, res2, res3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = findViewById(R.id.res);
        res2 = findViewById(R.id.res2);
        res3 = findViewById(R.id.res3);
        //seto o sensor maneger que me devolve o mSensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //escolho o tipo do que irei usar
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Recebo os valores.
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // lembrar q você passa a localização do valor que você recebe do vetor, sabendo que esse vetor irá receber 3 valores, dei uma posição pra cada
        res.setText(Float.toString(sensorEvent.values[0]));
        res2.setText(Float.toString(sensorEvent.values[1]));
        res3.setText(Float.toString(sensorEvent.values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}