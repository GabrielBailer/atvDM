package com.ifsc.banana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edmin, edmax;
    TextView textView;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(v -> {
            int min = Integer.parseInt(edmin.getText().toString());
            int max = Integer.parseInt(edmax.getText().toString());
            Random random = new Random();

            int R=random.nextInt(max-min)+max;

            textView.setText(Integer.toString(R));

        });

    }

    @Override
    public void onClick(View v) {

    }
}