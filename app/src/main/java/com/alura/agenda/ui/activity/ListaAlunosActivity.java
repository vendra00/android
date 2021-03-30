package com.alura.agenda.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alura.agenda.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alura.agenda.R.layout.activity_lista_alunos;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lista_alunos);

        List<String> alunos = new ArrayList<>(Arrays.asList("Pedro", "Ana", "Julia", "Joana", "Carlos", "Olivia"));

       ListView llistaAlunos = findViewById(R.id.activity_lista_alunos_listView);
       llistaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));


    }
}
