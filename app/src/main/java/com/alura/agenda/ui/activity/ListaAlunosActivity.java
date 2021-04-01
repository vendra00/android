package com.alura.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
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
import static com.alura.agenda.ui.activity.ConstatesActivities.CHAVE_ALUNO;

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
        dao.salvar(new Aluno("Gabriel", "Vendramini", "633863056", "gabriel@email.com"));
        dao.salvar(new Aluno("Clara", "Palmada", "993863056", "clara@email.com"));
        dao.salvar(new Aluno("Lua", "Lulis", "444863056", "lua@email.com"));
        dao.salvar(new Aluno("Sasha", "Sashis", "444863056", "sasha@email.com"));
    }

    private void configuraBtNovoAluno() {
        FloatingActionButton btNovoAluno = findViewById(R.id.activity_lista_aluno_bt_adicionar_aluno);
        btNovoAluno.setOnClickListener(view -> abreFormularioModoInsereAluno());
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
    }

    private void configuraLista() {
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_listView);
        final List<Aluno> alunos = dao.todos();
        configuraAdapter(listaAlunos, alunos);
        configuraListaDeClickPorItem(listaAlunos);
    }

    private void configuraAdapter(ListView listaAlunos, List<Aluno> alunos) {
        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));
    }

    private void configuraListaDeClickPorItem(ListView listaAlunos) {
        listaAlunos.setOnItemClickListener((adapterView, view, position, id) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(position);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }

    private void abreFormularioModoEditaAluno(Aluno aluno) {
        Intent vaiParaFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiParaFormularioActivity.putExtra(CHAVE_ALUNO, aluno);
        startActivity(vaiParaFormularioActivity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        configuraLista();
    }
}
