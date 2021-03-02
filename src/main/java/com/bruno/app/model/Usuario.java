package com.bruno.app.model;

public class Usuario {
    private String nome;
    private String id;

    public Usuario(String name) {
        this.nome = name;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}