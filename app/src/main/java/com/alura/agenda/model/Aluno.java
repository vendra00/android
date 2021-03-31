package com.alura.agenda.model;

import androidx.annotation.NonNull;

public class Aluno {

    private final String nome;
    private final String sobrenome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String sobrenome, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }
}
