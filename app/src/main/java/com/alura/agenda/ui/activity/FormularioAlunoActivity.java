package com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.dao.AlunoDAO;
import com.alura.agenda.model.Aluno;

import java.io.Serializable;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Novo Aluno";

    final AlunoDAO dao = new AlunoDAO();

    private EditText campoNome;
    private EditText campoSobrenome;
    private EditText campoTelefone;
    private EditText campoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APP_BAR);
        InicializaCampos();
        configuraBtSalvar();
        carregaDadosAlunoSelecionado();

    }

    private void carregaDadosAlunoSelecionado() {
        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra( "aluno");
        campoNome.setText(aluno.getNome());
        campoSobrenome.setText(aluno.getSobrenome());
        campoTelefone.setText(aluno.getTelefone());
        campoEmail.setText(aluno.getEmail());
    }


    private void configuraBtSalvar() {
        Button btSalvar = findViewById(R.id.activity_formulario_aluno_bt_salvar);
        btSalvar.setOnClickListener(view -> {

            Aluno alunoCriado = criaAluno();
            salva(alunoCriado);
        });
    }

    private void InicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoSobrenome = findViewById(R.id.activity_formulario_aluno_sobrenome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String sobrenome = campoSobrenome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, sobrenome, telefone, email);
    }
}