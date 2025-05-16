package com.ifsc.banana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //inicio da aula
    ListView lv;
    String[] frutas = new String[]{"Pera", "Banana", "Melancia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);

        PlanetaAdapter planetaAdapter = new PlanetaAdapter( this,
                R.layout.item_lista,
                (  new DAOPlanetas()).listplanetas);

        lv.setAdapter(planetaAdapter);

// inicio da aula!
        /** ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, frutas);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ActivityB.class);
                Bundle b = new Bundle();

                b.putInt("posicao",position);
                b.putString("Fruta", frutas[position]);

                i.putExtras(b);

                startActivity(i);

            }
        });
**/
    }
}