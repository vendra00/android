package com.alura.agenda.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoSobrenome = findViewById(R.id.activity_formulario_aluno_sobrenome);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);

        Button btSalvar = findViewById(R.id.activity_formulario_aluno_bt_salvar);
        btSalvar.setOnClickListener(view -> {

            String nome = campoNome.getText().toString();
            String sobrenome = campoSobrenome.getText().toString();
            String telefone = campoTelefone.getText().toString();
            String email = campoEmail.getText().toString();

            Aluno aluno = new Aluno(nome, sobrenome, telefone, email);

        });
    }
}