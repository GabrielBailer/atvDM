package com.ifsc.banana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonFragmentA, buttonFragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincula os botões
        buttonFragmentA = findViewById(R.id.buttonFragmentA);
        buttonFragmentB = findViewById(R.id.buttonFragmentB);

        // Listener para os botões
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;

                int id = v.getId();
                if (id == R.id.buttonFragmentA) {
                    fragment = new FragmentA();
                } else if (id == R.id.buttonFragmentB) {
                    fragment = new FragmentB();
                }

                if (fragment != null) {
                    abreFragmento(fragment);
                }
            }
        };

        // Atribui o listener aos botões
        buttonFragmentA.setOnClickListener(onClickListener);
        buttonFragmentB.setOnClickListener(onClickListener);
    }

    // Método para trocar o fragmento exibido
    public void abreFragmento(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }
}
