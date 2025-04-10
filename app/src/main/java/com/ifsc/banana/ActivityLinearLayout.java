package com.ifsc.banana;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityLinearLayout extends AppCompatActivity {

    EditText edtNome, edtEmail;
    RadioGroup rgCurso;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        // Referências aos componentes
        edtNome = findViewById(R.id.edt_nome);
        edtEmail = findViewById(R.id.edt_email);
        rgCurso = findViewById(R.id.rg_curso);
        btnEnviar = findViewById(R.id.btn_enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();

                int idSelecionado = rgCurso.getCheckedRadioButtonId();
                RadioButton rbSelecionado = findViewById(idSelecionado);
                String curso = (rbSelecionado != null) ? rbSelecionado.getText().toString() : "Nenhum curso selecionado";

                String mensagem = "Nome: " + nome + "\nEmail: " + email + "\nCurso: " + curso;

                Toast.makeText(ActivityLinearLayout.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });
    }
}