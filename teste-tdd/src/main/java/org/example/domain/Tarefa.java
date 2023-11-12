package org.example.domain;

import org.example.domain.enums.StatusTarefa;

public class Tarefa {

    private static int count = 0;
    private Integer id;
    private String nome;
    private String descricao;
    private StatusTarefa status;

    public Tarefa(String nome, String descricao, StatusTarefa status) {
        this.descricao = descricao;
        this.nome = nome;
        this.status = status;
        id = count++;
    }

    public Tarefa(Integer id, String nome, String descricao, StatusTarefa status) {
        this.descricao = descricao;
        this.nome = nome;
        this.status = status;
        this.id = id;
    }

    public Tarefa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa(String descricao, StatusTarefa status) {
        this.status = status;
        this.descricao = descricao;
    }

    public Tarefa(StatusTarefa status) {
        this.status = status;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }
}
