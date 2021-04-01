package com.alura.agenda.ui.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;
import com.alura.agenda.dao.AlunoDAO;
import com.alura.agenda.model.Aluno;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

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
        preCargaDeListaAlunos();
    }

    private void preCargaDeListaAlunos() {
        dao.salva(new Aluno("Gabriel", "Vendramini", "633863056", "gabriel@email.com"));
        dao.salva(new Aluno("Clara", "Palmada", "993863056", "clara@email.com"));
        dao.salva(new Aluno("Lua", "Lulis", "444863056", "lua@email.com"));
        dao.salva(new Aluno("Sasha", "Sashis", "444863056", "sasha@email.com"));
    }

    private void configuraBtNovoAluno() {
        FloatingActionButton btNovoAluno = findViewById(R.id.activity_lista_aluno_bt_adicionar_aluno);
        btNovoAluno.setOnClickListener(view -> abreFormularioAlunoActivity());
    }

    private void abreFormularioAlunoActivity() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    private void configuraLista() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listView);
        final List<Aluno> alunos = dao.todos();
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
        carregaAlunoSelecionadoDaLista(listaAlunos, alunos);
    }

    private void carregaAlunoSelecionadoDaLista(ListView listaAlunos, List<Aluno> alunos) {
        listaAlunos.setOnItemClickListener((parent, view, position, id) -> {
            Aluno alunoEscolhido = alunos.get(position);
            Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
            vaiParaFormularioActivity.putExtra( "aluno", alunoEscolhido);
            startActivity(vaiParaFormularioActivity);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }
}
