package com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.dao.AlunoDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.alura.agenda.R.layout.activity_lista_alunos;

public class ListaAlunosActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Lista Alunos";

    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_alunos);
        setTitle(TITULO_APP_BAR);
        configuraBtNovoAluno();
    }

    private void configuraBtNovoAluno() {
        FloatingActionButton btNovoAluno = findViewById(R.id.activity_lista_aluno_bt_adicionar_aluno);
        btNovoAluno.setOnClickListener(view -> abreFormularioAlunoActivity());
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }

    private void configuraLista() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listView);
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
