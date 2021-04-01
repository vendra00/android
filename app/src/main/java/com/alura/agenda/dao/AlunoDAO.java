package com.alura.agenda.dao;

import com.alura.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public void salvar(Aluno aluno) {
        aluno.setId(contadorId);
        alunos.add(aluno);
        atualizaId();
    }

    private void atualizaId() {
        contadorId++;
    }

    public void editar(Aluno aluno){
        Aluno alunoEncontrado = buscaAlunoPoloId(aluno);
        if (alunoEncontrado != null){
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);
        }
    }

    private Aluno buscaAlunoPoloId(Aluno aluno) {
        for (Aluno a : alunos) {
            if(a.getId() == aluno.getId()){
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
