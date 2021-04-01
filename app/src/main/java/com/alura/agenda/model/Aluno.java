package com.alura.agenda.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int id = 0;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;

    public Aluno() {

    }

    public Aluno(String nome, String sobrenome, String telefone, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }


    public boolean temIdValido() {
        return id > 0;
    }
}
